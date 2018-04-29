package observer;

public interface Subject {
	
	 void subscribe(Observer observer);//añadir observers
	 void notifyObserver();
	 
}
