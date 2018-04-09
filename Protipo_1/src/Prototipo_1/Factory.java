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
 }
