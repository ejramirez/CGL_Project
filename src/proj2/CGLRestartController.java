package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CGLRestartController implements ActionListener{

	private CGLPanel panel;
	private CGLGameUIPanel ui;
	private CGLModel model;
	private CGLView view;
	
	public CGLRestartController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Restart.");
		
		if(!this.model.isTicking()){
			this.model.reset();
			this.view.setTime("0");
			this.panel.setALP(new ArrayList<Pair<Integer,Integer>>());
			this.panel.redraw();
			this.model.restart();
		}
	}
	
	public void setGamePanel(CGLGameUIPanel u){
		this.ui = u;
	}
	
	public void setModel(CGLModel m){
		this.model = m;
	}
	
	public void setPanel(CGLPanel p){
		this.panel = p;
	}
	
	public void setView(CGLView v){
		this.view = v;
	}

}
