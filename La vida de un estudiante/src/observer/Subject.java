package observer;

public interface Subject {
	
	 void subscribe(Observer observer);//a�adir observers
	 void notifyObserver();
	 
}
