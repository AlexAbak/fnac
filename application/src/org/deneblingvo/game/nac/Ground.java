package org.deneblingvo.game.nac;

public class Ground {
	
	private Cell[] ground = {
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR,
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR,
		Cell.CLEAR, Cell.CLEAR, Cell.CLEAR
	};

	public Cell getCell(Col col, Row row) {
		return this.ground[(row.getId()+1)*3+(col.getId()+1)];
	}

	public Cell getCell(Position position) {
		return this.getCell(position.getCol(), position.getRow());
	}

	public void setCell(Col col, Row row, Cell cell) throws CellIsFull {
		if (this.getCell(col, row) != Cell.CLEAR) {
			throw new CellIsFull();
		}
		this.ground[(row.getId()+1)*3+(col.getId()+1)] = cell;
	}

	public void setCell(Position position, Cell cell) throws CellIsFull {
		this.setCell(position.getCol(), position.getRow(), cell);
	}

}
