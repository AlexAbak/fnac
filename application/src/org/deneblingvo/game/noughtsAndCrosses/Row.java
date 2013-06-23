package org.deneblingvo.game.noughtsAndCrosses;

public enum Row {

	TOP(-1), MIDDLE(0), BOTTOM(1);

	Row(int id) {
		this.id = id;
    }

    private int id;

    public int getId() {
    	return id;
    }

    public static String getClassName() {
        return Row.class.getName();
    }

}
