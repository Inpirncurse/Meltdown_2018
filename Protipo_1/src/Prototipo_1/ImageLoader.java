package Prototipo_1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private BufferedImage buho;
	public static ImageLoader imgLoader;
	
	
	public ImageLoader() {
		try {
			buho = ImageIO.read(new File("src\\Imagenes Mago\\buho.png")); 

		}catch (IOException e) {}
	}
	
	public static ImageLoader getImageLoader(){
		if(imgLoader == null){
			imgLoader = new ImageLoader();
		}
		return imgLoader;
	}
	

	
	public BufferedImage getBuho() {
		return buho;
	}


}