package Pokemon;

//import stuff
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame{

	/**
	 * Main Game Frame
	 * @author Diwen Wang
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(100, 100, 200, 100);
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
				
		//this.setLocation(width, screenSize);
		
		//triggered windows events
		this.addWindowListener(new WindowAdapter() {
			//window closing
			public void windowClosing(WindowEvent e) {
			System.exit(0);  //
			}
		});
		
		this.setVisible(true);  //set frame to visible
	}
	
	public static void main(String[] args) {
		GameFrame f = new GameFrame();
		f.lauchFrame();
	}

}
