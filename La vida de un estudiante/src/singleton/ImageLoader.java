package singleton;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static ImageLoader imgLoader;
	
	private String[] tags = new String[] {
			"background",
			"gato",
			"gato2",
			"nina",
			"edgar",
			"lapiz"};
	
	
	private BufferedImage images [] = new BufferedImage[6];
		
	public ImageLoader() {
		try {
			
			for(int i = 0; i < 6; i++) {
				
				images [i] = ImageIO.read(new File("Images/" + tags[i] + ".png")); 
			}
			
		}catch (IOException e) {}
	}
	
	public static ImageLoader getImageLoader(){
		if(imgLoader == null){
			imgLoader = new ImageLoader();
		}
		return imgLoader;
	}
	
	public BufferedImage getImage(int a) {
		return images[a];
	}


}
