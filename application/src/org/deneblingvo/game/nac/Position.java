package org.deneblingvo.game.nac;

public class Position {

	public Position(Col col, Row row) {
		this.col = col;
		this.row = row;
    }
	
	public Position(int i) {
		this.col = Col.fromId((i % 3) - 1);
		this.row = Row.fromId((i / 3) - 1);
	}
	
	private Col col;

	private Row row;
	
	public Col getCol() {
    	return this.col;
    }

	public Row getRow() {
    	return this.row;
    }
	
	public int getIndex() {
		return (this.row.getId()+1)*3+(this.col.getId()+1);
	}

}
