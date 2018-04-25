package Prototipo_1;

public class Factory{
//Factory principal
    private static Factory factory;

   public Factory(){
    }

   
   //Metodo retornable del mismo factory
    public  Factory getFactory(){
      if(factory==null){
    	  
    	  
        factory= new Factory();
      }
      return factory;
    }
    
    
    //metodo para maquina de estados
    public GameState createState(String tag,GameContext gc){
      if(tag.equalsIgnoreCase("run")){//estado run
        return new GameStateRunning(gc);
      }
      if(tag.equalsIgnoreCase("pause")){//estado pause
          return new GameStatePause(gc);
        }
      if(tag.equalsIgnoreCase("go")){
          return new GameStateGameOver(gc);//estado fin
        }
    
      
      return null;
    }

    public GameState createEnemigos(String tag) {
    	if(tag.equalsIgnoreCase("EnemigoD")) {
    		return (GameState) new VillanoD(10, 20);
    	}
    	if(tag.equalsIgnoreCase("EnemigoF")) {
    		
        		return (GameState) new VillanoF(20, 40);
    	}
    	return null;
    }
    

 }
