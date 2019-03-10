/**
 * Main Game Frame
 * @author Diwen Wang
 * 3/9/2019
 * Finished pic loading, next step is to the battle screen and skill choice
 */
package Pokemon;
//import stuff
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame{
	
	Image bulbasaur = GameUti.getImage("image/240px-001Bulbasaur.png");
	Image charmander = GameUti.getImage("image/240px-004Charmander.png");
	Image squirtle = GameUti.getImage("image/240px-007Squirtle.png");
	
	int bul_x = 100, bul_y = 450;
	
	
	public void paint(Graphics g) {  //g is a painter
		super.paint(g);  //no idea why, but needed to do this step
		
		//Color c = g.getColor();
		g.drawImage(bulbasaur, bul_x, bul_y, null);
		g.drawImage(charmander, 1000, 50, null);
		
	}
	
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
				System.out.println("123");
				repaint();  //repaint
				
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
	
	
	
	
	public void lauchFrame() {
		//properties of the frame		
		this.setTitle("Pokemon");  //name
		
		
		//screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();//achieve Toolkit
		Dimension screen = toolkit.getScreenSize();//get the screen size
		int width = screen.width;
		int height = screen.height;
		this.setSize(width, height);
				
		this.setLocation(0,0);  //Initially window location
		
		//triggered windows events
		this.addWindowListener(new WindowAdapter() {
			//window closing
			public void windowClosing(WindowEvent e) {
			System.exit(0);  //0 represented quit
			}
		});
		
		new PaintThread().start();  //initialize repaint window
		
		this.setVisible(true);  //set frame to visible
	}
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		
		if (offScreenImage == null) {
			offScreenImage = this.createImage(500, 500);
			Graphics gOff = offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage, 0, 0, null);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		GameFrame f = new GameFrame();
		f.lauchFrame();
	}

}
