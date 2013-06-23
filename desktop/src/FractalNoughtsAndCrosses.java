import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.deneblingvo.game.nac.CellIsFull;
import org.deneblingvo.game.nac.Col;
import org.deneblingvo.game.nac.Game;
import org.deneblingvo.game.nac.GameIsEnd;
import org.deneblingvo.game.nac.Position;
import org.deneblingvo.game.nac.Row;

public class FractalNoughtsAndCrosses extends Canvas {

	private static final long serialVersionUID = -658709322990713991L;

	private Game game;
	
	FractalNoughtsAndCrosses() throws GameIsEnd, CellIsFull {
		this.game = new Game();
		this.game.Next(new Position(Row.MIDDLE, Col.MIDDLE));
		this.game.Next(new Position(Row.TOP, Col.RIGHT));
	}

	public void paint(Graphics g) {
		Painter.paint(this.game, g, new Rectangle(0, 0, getWidth(), getHeight()));
	}
	
	public static void main(String[] args) throws GameIsEnd, CellIsFull {
	    Frame f = new Frame("Test frame");
	    f.setSize(400, 300);
	    f.add(new FractalNoughtsAndCrosses());
	    f.setVisible(true);
	    f.addWindowListener(new WindowClosingAdapter());
	}

}
