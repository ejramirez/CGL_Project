package proj2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CGLStopController implements ActionListener{

	private CGLGameUIPanel ui;
	private CGLModel model;
	
	public CGLStopController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Stop.");
		this.model.setTimeState(false);
		
	}
	
	public void setModel(CGLModel m){
		this.model = m;
	}
	
	public void setView(CGLGameUIPanel p){
		this.ui = p;
	}

}
