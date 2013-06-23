package org.deneblingvo.game.nac;

public enum Step {

	CROSS(0), NOUGHT(1), CROSSWIN(2), NOUGHTWIN(3), DRAW(4);

	Step(int id) {
		this.id = id;
    }

    private int id;

    public int getId() {
    	return id;
    }

    public static String getClassName() {
        return Step.class.getName();
    }

}
