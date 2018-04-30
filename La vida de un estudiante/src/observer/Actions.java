package observer;

import stateMachine.GameContext;

public class Actions implements Observer{
	private GameContext context;
	
	public Actions (GameContext context) {
		this.context = context;
		KeyboardSubject.getInstance().subscribe(this);
	}
	public void update(Subject subject) {
		System.out.println("exit");
		if (subject == KeyboardSubject.getInstance()) {
			if(KeyboardSubject.getInstance().getLastPressed() == "attack") {
				
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "exit") {
				System.out.println("exit");
				if(context.getState() == context.getStart() || context.getState() == context.getRun() || context.getState() == context.getGO()) {
					
					System.exit(0);
				}
			}
		}
}

}
