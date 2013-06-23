package org.deneblingvo.game.nac;

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

	public static Row fromId(int i) {
		for (Row row : Row.values()) {
			if (row.getId() == i) {
				return row;
			}
		}
		throw new IllegalArgumentException(Integer.toString(i));			
	}

}
