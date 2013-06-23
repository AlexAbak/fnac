package org.deneblingvo.game.nac;

public enum Col {

	LEFT(-1), MIDDLE(0), RIGHT(1);

	Col(int id) {
		this.id = id;
    }

    private int id;

    public int getId() {
    	return id;
    }

    public static String getClassName() {
        return Col.class.getName();
    }

	public static Col fromId(int i) {
		for (Col col : Col.values()) {
			if (col.getId() == i) {
				return col;
			}
		}
		throw new IllegalArgumentException();			
	}

}
