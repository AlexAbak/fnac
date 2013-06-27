package org.deneblingvo.android.fnac;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import org.deneblingvo.game.nac.*;
import android.view.View.*;

public class ButtonGrid
{

	private Button[] grid = new Button[9];
	
	public Button getCell(Col col, Row row) {
		return this.getCell(new Position(col, row));
	}
	
	public Button getCell(Position position) {
		return this.grid[position.getIndex()];
	}

	public void setCell(Col col, Row row, Button button) {
		this.setCell(new Position(col, row), button);
	}
	
	public void setCell(Position position, Button button) {
		this.grid[position.getIndex()] = button;
	}
	
	public Position getPosition(Button button) throws ButtonNotFound {
		for (int i = 0; i < 9; i++) {
			if (this.grid[i] == button) {
				return new Position(i);
			}
		}
		throw new ButtonNotFound();
	}
	
	public void setOnClickListener(OnClickListener l) {
		for (int i = 0; i < 9; i++) {
			this.grid[i].setOnClickListener(l);
		}
	}
	
}
