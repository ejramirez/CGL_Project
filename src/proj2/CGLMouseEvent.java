package proj2;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CGLMouseEvent implements MouseListener{

	private CGLPanel panel;
	private CGLModel model;
	
	public CGLMouseEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point p = e.getPoint();

		int row = (int) Math.floor(p.getY() / 20);
		int column = (int) Math.floor(p.getX() / 20);
		
		
		System.out.println("Row: " + row + " Column: " + column);
		this.model.addClicked(column,row);
		
	}
	
	public void setPanel(CGLPanel p){
		this.panel = p;
	}
	
	public void setModel(CGLModel m){
		this.model = m;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
