package org.deneblingvo.game.noughtsAndCrosses;

public class Game {

	private Ground ground;

	private Step step;

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
		
	}

}
