package org.deneblingvo.android.fnac;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import org.deneblingvo.game.nac.*;

public class MainActivity extends Activity implements OnClickListener
{

	private Game game = new Game();
	private ButtonGrid grid = new ButtonGrid();
	
	private void paintGame() {
		for (int i = 0; i < 9; i++) {
			Position position = new Position(i);
			Cell cell = this.game.getGround().getCell(position);
			Button button = this.grid.getCell(position);
			if (cell != Cell.CLEAR) {
				if (cell == Cell.CROSS) {
					button.setText("X");
				} else {
					button.setText("O");
				}
			} else {
				button.setText(".");
			}
		}
		TextView message = (TextView)findViewById(R.id.message);	
		if (this.game.getStep() == Step.CROSS) {
			message.setText(R.string.cross);
		}
		if (this.game.getStep() == Step.NOUGHT) {
			message.setText(R.string.nought);
		}
		if (this.game.getStep() == Step.CROSSWIN) {
			message.setText(R.string.crosswin);
		}
		if (this.game.getStep() == Step.NOUGHTWIN) {
			message.setText(R.string.noughtwin);
		}
		if (this.game.getStep() == Step.DRAW) {
			message.setText(R.string.draw);
		}
	}
	
	public void onClick (View v) {
		TextView message = (TextView)findViewById(R.id.message);
		Button button = (Button)v;
		try {
			Position position = this.grid.getPosition(button);
			this.game.Next(position);
			this.paintGame();
		} catch (ButtonNotFound e) {
			this.game = new Game();
			this.paintGame();
		} catch (CellIsFull e) {
			message.setText(R.string.cell_is_full);
		} catch (GameIsEnd e) {
			message.setText(R.string.game_is_end);
		}
	
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		this.grid.setCell(Col.LEFT, Row.TOP, (Button)findViewById(R.id.tl));
		this.grid.setCell(Col.MIDDLE, Row.TOP, (Button)findViewById(R.id.tm));
		this.grid.setCell(Col.RIGHT, Row.TOP, (Button)findViewById(R.id.tr));
		this.grid.setCell(Col.LEFT, Row.MIDDLE, (Button)findViewById(R.id.ml));
		this.grid.setCell(Col.MIDDLE, Row.MIDDLE, (Button)findViewById(R.id.mm));
		this.grid.setCell(Col.RIGHT, Row.MIDDLE, (Button)findViewById(R.id.mr));
		this.grid.setCell(Col.LEFT, Row.BOTTOM, (Button)findViewById(R.id.bl));
		this.grid.setCell(Col.MIDDLE, Row.BOTTOM, (Button)findViewById(R.id.bm));
		this.grid.setCell(Col.RIGHT, Row.BOTTOM, (Button)findViewById(R.id.br));
		this.grid.setOnClickListener(this);
		Button button = (Button)findViewById(R.id.newGame);
		button.setOnClickListener(this);
		this.paintGame();
	}
}
