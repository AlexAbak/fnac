import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;


public class FractalNoughtsAndCrosses extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -658709322990713991L;

	public void paint(Graphics g) {
		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(0, getHeight(),getWidth(), 0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Frame f = new Frame("Test frame");
	    f.setSize(400, 300);
	    f.add(new FractalNoughtsAndCrosses());
	    f.setVisible(true);
	    f.addWindowListener(new WindowClosingAdapter());
	}

}
