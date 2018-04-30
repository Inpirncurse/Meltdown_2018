package singleton;

import characters.MainCharacter;
import entities.Entity;
import game.Pencil;
import stateMachine.GameState;
import stateMachine.GameStateOver;
import stateMachine.GameStateRunning;
import stateMachine.GameStateStart;

public class Factory {
	

	private static Factory instance;

	private Factory(){}

    public static Factory getInstance(){
    	
      if(instance==null){
    	  instance= new Factory();  
      }
      return instance;
      }

    public GameState createState(String tag){
    	
    	if(tag.equalsIgnoreCase("start")){
    	   		
	    	return new GameStateStart();
	    	
      }
    	
      if(tag.equalsIgnoreCase("run")){

	    	return new GameStateRunning();
	    	
      }
      if(tag.equalsIgnoreCase("go")){
    	  
	    	return new GameStateOver();
	    	
      }
      return null;
    }
    
    public Entity getEntity(String tag) {
    	if(tag.equalsIgnoreCase("girl")){
	   		
	    	return new MainCharacter();
	    	
      }
    	if (tag.equalsIgnoreCase("pencil")) {
    		return new Pencil();
    	}
    	return null;
    }
    
}
