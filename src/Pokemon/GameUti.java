package Pokemon;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

public class GameUti {
	private GameUti() {
	}
	
	public static Image getImage(String path) {
		BufferedImage bi = null;
		try {
			java.net.URL u = GameUti.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return bi;
	}
}
