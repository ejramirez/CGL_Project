package proj2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class CGLView implements Observer{

	private JFrame frame;
	private CGLPanel graphicsPanel;
	private CGLGameUIPanel gameUI;
	private JPanel mainPanel;
	private Timer t;
	private JLabel time;
	
	public CGLView(CGLStartController start, CGLStopController stop, CGLTimerController ti, CGLMouseEvent me, CGLRestartController restart, CGLRandomController random) {
		
		this.mainPanel = new JPanel();
		this.graphicsPanel = new CGLPanel();
		this.gameUI = new CGLGameUIPanel(start,stop,restart,random);
		this.time = new JLabel();
		
		this.t = new Timer(0,ti);
		this.t.setInitialDelay(1000);
		this.t.setDelay(500);
		
		this.time.setText("0");
		this.gameUI.add(this.time);
		
		this.graphicsPanel.addMouseListener(me);
		
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.X_AXIS));
		this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.mainPanel.add(this.graphicsPanel, BorderLayout.WEST);
		this.mainPanel.add(this.gameUI, BorderLayout.EAST);
		this.mainPanel.setPreferredSize(new Dimension(627,400));
		
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setTitle("Conway's Game of Life");
		this.frame.setContentPane(this.mainPanel);
		
	}
	
	public void launchGUI(){
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	public CGLGameUIPanel getGameUI(){
		return this.gameUI;
	}
	
	public CGLPanel getPanel(){
		return this.graphicsPanel;
	}
	
	public void setTime(String s){
		this.time.setText(s);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		CGLModel m = (CGLModel) o;
		
		if(m.isTicking() && !t.isRunning()){
			this.t.start();
		}else if(t.isRunning() && !m.isTicking()){
			this.t.stop();
		}
		
		if(m.isTicking() && t.isRunning()){
			this.time.setText(Integer.toString(m.getGeneration()));
			this.graphicsPanel.setALP(m.getAlive());
		}else{
			this.graphicsPanel.addToAlp(m.getPair());
			this.graphicsPanel.setALP(m.getAlive());
		}
		
		
		this.graphicsPanel.redraw();
	}

}
