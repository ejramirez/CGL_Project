package proj2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CGLGameUIPanel extends JPanel{
	
	private JButton start;
	private JButton stop;
	private JButton restart;
	private JButton random;
	
	public CGLGameUIPanel(CGLStartController start, CGLStopController stop, CGLRestartController restart, CGLRandomController random) {
		
		this.start = new JButton();
		this.stop = new JButton();
		this.restart = new JButton();
		this.random = new JButton();
		
		this.start.setText("Start");
		this.stop.setText("Stop");
		this.restart.setText("Restart");
		this.random.setText("Randomize");
		
		this.start.addActionListener(start);
		this.stop.addActionListener(stop);
		this.restart.addActionListener(restart);
		this.random.addActionListener(random);
		
		BoxLayout Box = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		this.setLayout(Box);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(this.start);
		this.add(this.stop);
		this.add(this.restart);
		this.add(this.random);
	}

	public Dimension getPreferredSize(){
		return new Dimension(125,100);
	}

}
