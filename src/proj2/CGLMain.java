package proj2;

public class CGLMain {

	public static void main(String[] args) {
		
		CGLStartController start = new CGLStartController(); // Start Controller
		CGLStopController stop = new CGLStopController(); // Stop Controller
		CGLTimerController time = new CGLTimerController(); // Time Controller
		CGLMouseEvent click = new CGLMouseEvent(); // MouseEvent Controller
		CGLRestartController restart = new CGLRestartController(); // Restart Controller
		CGLRandomController random = new CGLRandomController(); // Random Controller
		
		CGLModel model = new CGLModel();
		CGLView view = new CGLView(start, stop, time, click, restart, random);
		
		model.addObserver(view); // Adding View as observer
		
		//Setup for all the controllers
		
		start.setView(view.getGameUI());
		start.setModel(model);
		
		stop.setView(view.getGameUI());
		stop.setModel(model);
		
		time.setView(view);
		time.setModel(model);
		
		click.setPanel(view.getPanel());
		click.setModel(model);
		
		restart.setGamePanel(view.getGameUI());
		restart.setModel(model);
		restart.setPanel(view.getPanel());
		restart.setView(view);
		
		random.setGamePanel(view.getGameUI());
		random.setModel(model);
		random.setPanel(view.getPanel());
		random.setView(view);
		
		view.launchGUI();
		
	}

}
