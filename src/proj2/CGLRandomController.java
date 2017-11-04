package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CGLRandomController implements ActionListener{

	private CGLPanel panel;
	private CGLGameUIPanel ui;
	private CGLModel model;
	private CGLView view;
	
	public CGLRandomController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Random");
		
		if(!this.model.isTicking()){
			this.model.reset();
			this.view.setTime("0");
			this.panel.setALP(new ArrayList<Pair<Integer,Integer>>());
			this.panel.redraw();
			this.model.random();
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
