import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Memory extends JFrame
{
	Container cont;
	ImageIcon blankImage = new ImageIcon("C:\\Users\\wolve\\workspace\\Memorama\\src\\cardBack.png"); //Create a blank Image and include the path here
	JButton buttons[][] = {{new JButton(blankImage), new JButton(blankImage), new JButton(blankImage), new JButton(blankImage)},
			{new JButton(blankImage), new JButton(blankImage), new JButton(blankImage), new JButton(blankImage)},
			{new JButton(blankImage), new JButton(blankImage), new JButton(blankImage), new JButton(blankImage)},
			{new JButton(blankImage), new JButton(blankImage), new JButton(blankImage), new JButton(blankImage)}};
	
	int locations [][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	
	public Memory()
	{
		super("Memory");
		setSize(415, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cont = getContentPane();
		cont.setLayout(null);
		
		for(int i=0; i<buttons[0].length; i++)
		{
			for(int j=0; j<buttons.length; j++)
			{
				cont.add(buttons[i][j]);
				buttons[i][j].setBounds(i*100, j*100, 100, 100);
			}
		}
		
		mixup();
	}
	
	private void mixup()
	{
		try 
		{
			Thread.sleep(500);
			int usedCount[] = {0,0,0,0,0,0,0,0};
			
			for(int i=0; i<buttons[0].length; i++)
			{
				for(int j=0; j<buttons.length; j++)
				{
					//create a random number
					int rand = (int)(Math.random() * 8) + 1;
					while(usedCount[rand - 1] > 1)
					{
						//find a better random number
						rand = (int)(Math.random() * 8) + 1;
						
						//this makes sure you don't use an image more than twice
						usedCount[rand-1]++;
						//set the image
						buttons[i][j].setIcon(new ImageIcon(""));
						//keep track of the images
						locations[i][j] = rand;
						cont.validate();
					}		
				}
			}
				//pause
				Thread.sleep(3000);
				
				for(int i=0; i<buttons[0].length; i++)
				{
					for(int j=0; j<buttons.length; j++)
					{
						//change icons back
						buttons[i][j].setIcon(blankImage);
						cont.validate();
					}
				}
		}
		catch (Exception e)
		{
			
		}
		
	}
	

}

