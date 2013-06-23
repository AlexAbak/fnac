import java.awt.Graphics;
import java.awt.Rectangle;

import org.deneblingvo.game.nac.Cell;
import org.deneblingvo.game.nac.Col;
import org.deneblingvo.game.nac.Game;
import org.deneblingvo.game.nac.Row;

public class Painter {

	private static void paintCell(Cell cell, Graphics g, Rectangle rect) {
		Rectangle r = new Rectangle(
			rect.x + (rect.width / 10),
			rect.y + (rect.height / 10),
			rect.width - (rect.width / 5),
			rect.height - (rect.height / 5)
		);
		if (cell == Cell.CROSS) {
			g.drawLine(r.x, r.y, r.x + r.width, r.y + r.height);
			g.drawLine(r.x, r.y + r.height, r.x + r.width, r.y);
		}
		if (cell == Cell.NOUGHT) {
			g.drawOval(r.x, r.y, r.width, r.height);
		}
	}

	public static void paint(Game game, Graphics g, Rectangle rect) {
		g.drawLine(
			rect.x + 1 * (rect.width / 3),
			rect.y + 1 * (rect.height / 10),
			rect.x + 1 * (rect.width / 3),
			rect.y + 9 * (rect.height / 10)
		);
		g.drawLine(
			rect.x + 2 * (rect.width / 3),
			rect.y + 1 * (rect.height / 10),
			rect.x + 2 * (rect.width / 3),
			rect.y + 9 * (rect.height / 10)
		);
		g.drawLine(
			rect.x + 1 * (rect.width / 10),
			rect.y + 1 * (rect.height / 3),
			rect.x + 9 * (rect.width / 10),
			rect.y + 1 * (rect.height / 3)
		);
		g.drawLine(
			rect.x + 1 * (rect.width / 10),
			rect.y + 2 * (rect.height / 3),
			rect.x + 9 * (rect.width / 10),
			rect.y + 2 * (rect.height / 3)
		);
		for (Row row : Row.values()) {
			for (Col col : Col.values()) {
				paintCell(
					game.getGround().getCell(col, row),
					g,
					new Rectangle(
							rect.x + (col.getId() + 1) * (rect.width / 3),
							rect.y + (col.getId() + 1) * (rect.height / 3),
							rect.width / 3,
							rect.height / 3
					)
				);
			}
		}
	}

}
