package org.deneblingvo.game.nac;

public class Position {

	public Position(Row row, Col col) {
		this.row = row;
		this.col = col;
    }

	private Row row;
	
	private Col col;

	public Row getRow() {
    	return this.row;
    }

    public Col getCol() {
    	return this.col;
    }

}