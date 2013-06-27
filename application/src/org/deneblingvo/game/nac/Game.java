package org.deneblingvo.game.nac;

public class Game {

	public Game () {
		this.ground = new Ground();
		this.step = Step.CROSS;
	}

	private Ground ground;

	private Step step;

	private Cell getRowOwner(Row row) {
		Cell owner = this.ground.getCell(Col.LEFT, row);
		for (Col col : Col.values()) {
			if (owner != this.ground.getCell(col, row)) {
				return Cell.CLEAR;
			}
		}			
		return owner;
	}

	private Cell getColOwner(Col col) {
		Cell owner = this.ground.getCell(col, Row.TOP);
		for (Row row : Row.values()) {
			if (owner != this.ground.getCell(col, row)) {
				return Cell.CLEAR;
			}
		}			
		return owner;
	}

	private Cell getSlashOwner() {
		Cell owner = this.ground.getCell(Col.LEFT, Row.TOP);
		for (int i = -1; i <= 1; i++) {
			Row row = Row.fromId(i);
			Col col = Col.fromId(i);
			if (owner != this.ground.getCell(col, row)) {
				return Cell.CLEAR;
			}
		}
		return owner;
	}

	private Cell getBackSlashOwner() {
		Cell owner = this.ground.getCell(Col.LEFT, Row.BOTTOM);
		for (int i = -1; i <= 1; i++) {
			Row row = Row.fromId(0-i);
			Col col = Col.fromId(i);
			if (owner != this.ground.getCell(col, row)) {
				return Cell.CLEAR;
			}
		}
		return owner;
	}

	private Cell getGroundOwner() {
		Cell owner;
		for (Row row : Row.values()) {
			owner = getRowOwner(row);
			if (owner != Cell.CLEAR) {
				return owner;
			}
		}
		for (Col col : Col.values()) {
			owner = getColOwner(col);
			if (owner != Cell.CLEAR) {
				return owner;
			}
		}
		owner = getSlashOwner();
		if (owner != Cell.CLEAR) {
			return owner;
		}
		owner = getBackSlashOwner();
		if (owner != Cell.CLEAR) {
			return owner;
		}
		return Cell.CLEAR;
	}

	public Ground getGround() {
		return this.ground;
	}

	public Step getStep() {
		return this.step;
	}

	public void Next (Position position) throws GameIsEnd, CellIsFull {
		if (this.step == Step.CROSSWIN) {
			throw new GameIsEnd();
		}
		if (this.step == Step.NOUGHTWIN) {
			throw new GameIsEnd();
		}
		if (this.step == Step.DRAW) {
			throw new GameIsEnd();
		}
		if (this.step == Step.CROSS) {
        	this.ground.setCell(position, Cell.CROSS);
        	this.step = Step.NOUGHT;
		} else {
        	this.ground.setCell(position, Cell.NOUGHT);
        	this.step = Step.CROSS;
		}
		Cell owner = getGroundOwner();
		if (owner != Cell.CLEAR) {
			if (owner == Cell.CROSS) {
				this.step = Step.CROSSWIN;
			} else {
				this.step = Step.NOUGHTWIN;
			}
		} else {
			if (this.isFull()) {
				this.step = Step.DRAW;
			}
		}
	}

	private boolean isFull() {
		for (int i = 0; i < 9; i++) {
			if (this.ground.getCell(new Position(i)) == Cell.CLEAR) {
				return false;
			}
		}
		return true;
	}
}
