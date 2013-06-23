package org.deneblingvo.game.nac;

public class Game {

	public Game () {
		this.ground = new Ground();
		this.step = Step.CROSS;
	}

	private Ground ground;

	private Step step;

	private Cell getRowOwner(Row row) {
		Cell owner = Cell.CLEAR;
		for (Col col : Col.values()) {
			if (owner == Cell.CLEAR) {
				owner = this.ground.getCell(col, row);
			} else {
				if (owner != this.ground.getCell(col, row)) {
					return Cell.CLEAR;
				}
			}
		}			
		return owner;
	}

	private Cell getColOwner(Col col) {
		Cell owner = Cell.CLEAR;
		for (Row row : Row.values()) {
			if (owner == Cell.CLEAR) {
				owner = this.ground.getCell(col, row);
			} else {
				if (owner != this.ground.getCell(col, row)) {
					return Cell.CLEAR;
				}
			}
		}			
		return owner;
	}

	private Cell getSlashOwner() {
		Cell owner = Cell.CLEAR;
		for (int i = -1; i <= 1; i++) {
			Row row = Row.fromId(i);
			Col col = Col.fromId(i);
			if (owner == Cell.CLEAR) {
				owner = this.ground.getCell(col, row);
			} else {
				if (owner != this.ground.getCell(col, row)) {
					return Cell.CLEAR;
				}
			}
		}
		return owner;
	}

	private Cell getBackSlashOwner() {
		Cell owner = Cell.CLEAR;
		for (int i = -1; i <= 1; i++) {
			Row row = Row.fromId(0-i);
			Col col = Col.fromId(i);
			if (owner == Cell.CLEAR) {
				owner = this.ground.getCell(col, row);
			} else {
				if (owner != this.ground.getCell(col, row)) {
					return Cell.CLEAR;
				}
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
		}
	}

}
