package org.deneblingvo.game.noughtsAndCrosses;

public enum Cell {

	CLEAR(0), CROSS(1), NOUGHT(2);

	Cell(int id) {
		this.id = id;
    }

    private int id;

    public int getId() {
    	return id;
    }

    public static String getClassName() {
        return Cell.class.getName();
    }

}
