package proj2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGLTimerController implements ActionListener{

	private CGLModel model;
	private CGLView view;
	
	public CGLTimerController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.incrementGeneration();
		
	}
	
	public void setView(CGLView u){
		this.view = u;
	}
	
	public void setModel(CGLModel m){
		this.model = m;
	}

}
