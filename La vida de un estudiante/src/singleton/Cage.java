package singleton;

import characters.MainCharacter;

public class Cage {
	
	private static Cage cage; 
	
	public static Cage getInstance() {
		if (cage == null) {
			cage = new Cage();
		}
		return cage;
	}
	
	public MainCharacter getGirl() {
		return girl;
	}

	public void setGirl(MainCharacter girl) {
		this.girl = girl;
	}

	private MainCharacter girl = (MainCharacter) Factory.getInstance().getEntity("girl");
}
