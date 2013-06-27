package org.deneblingvo.game.nac;

public class Ground {
	
	private Cell[] ground = {
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR,
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR,
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR
	};

	public Cell getCell(Col col, Row row) {
		return this.getCell(new Position(col, row));
	}

	public Cell getCell(Position position) {
		return this.ground[position.getIndex()];
	}

	public void setCell(Col col, Row row, Cell cell) throws CellIsFull {
		this.setCell(new Position(col, row), cell);
	}

	public void setCell(Position position, Cell cell) throws CellIsFull {
		if (this.getCell(position) != Cell.CLEAR) {
			throw new CellIsFull();
		}
		this.ground[position.getIndex()] = cell;
	}

}
