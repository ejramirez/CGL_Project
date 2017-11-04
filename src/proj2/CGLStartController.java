package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CGLStartController implements ActionListener{

	private CGLModel model;
	private CGLGameUIPanel ui;
	
	public CGLStartController() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Start.");
		
		if(!this.model.isTicking()){
			this.model.setTimeState(true);
		}
		
	}
	
	public void setView(CGLGameUIPanel u){
		this.ui = u;
	}
	
	public void setModel(CGLModel m){
		this.model = m;
	}

	

}
