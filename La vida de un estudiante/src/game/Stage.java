package game;

import entities.Entity;
import singleton.Factory;
import singleton.ImageLoader;

public class Stage {
	
	private Entity girl = Factory.getInstance().getEntity("girl");
	
	public void MainCharacter() {
		girl.setImage(ImageLoader.getImageLoader().getImage(3));
	}

	public Entity getGirl() {
		return girl;
	}

	
}
