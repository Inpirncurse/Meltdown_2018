package observer;

import stateMachine.GameContext;

public class Actions implements Observer{
	KeyboardSubject kb = new KeyboardSubject();
	private GameContext context;
	
	public Actions (GameContext context) {
		this.context = context;
		kb.getInstance().subscribe(this);
	}
	public void update(Subject subject) {

	}

}
