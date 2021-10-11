package com.exercise.demo.entity;

import java.util.HashMap;

public class GridPointer {

	private Direction direction;
	private Cell currentCell;

	GridPointer(Cell currentCell) {
		this.direction = Direction.RIGHT;
		this.currentCell = currentCell;
	}

	/**
	 * change direction for the pointer
	 * 
	 * @author magrawal
	 */
	public void changeDirection() {
		HashMap<Direction, Direction> directionMap = new HashMap<>();

		if (this.currentCell.getColor().equals(Color.WHITE)) {
			directionMap.put(Direction.RIGHT, Direction.DOWN);
			directionMap.put(Direction.DOWN, Direction.LEFT);
			directionMap.put(Direction.LEFT, Direction.UP);
			directionMap.put(Direction.UP, Direction.RIGHT);

			this.direction = directionMap.get(this.direction);
		}

		if (this.currentCell.getColor().equals(Color.BLACK)) {
			directionMap.put(Direction.RIGHT, Direction.UP);
			directionMap.put(Direction.UP, Direction.LEFT);
			directionMap.put(Direction.LEFT, Direction.DOWN);
			directionMap.put(Direction.DOWN, Direction.RIGHT);

			this.direction = directionMap.get(this.direction);
		}
	}

	/**
	 * move the pointer in forward direction
	 * 
	 * @param grid Grid object
	 * @author magrawal
	 */
	public void movePointer(Grid grid) {
		int coordinateX = this.currentCell.getCoordinateX();
		int coordinateY = this.currentCell.getCoordinateY();

		if (this.direction.equals(Direction.RIGHT)) {
			coordinateX = coordinateX + 1;
		}

		if (this.direction.equals(Direction.LEFT)) {
			coordinateX = coordinateX - 1;
		}

		if (this.direction.equals(Direction.UP)) {
			coordinateY = coordinateY + 1;
		}

		if (this.direction.equals(Direction.DOWN)) {
			coordinateY = coordinateY - 1;
		}
		/* flip the color after moving */
		currentCell.flipColor();

		if (this.currentCell.getColor().equals(Color.BLACK)) {
			grid.addBlackCell(this.getCurrentCell());
		} else {
			grid.removeBlackCell(this.getCurrentCell());
		}

		Cell existingCell = grid.findBlackCell(coordinateX, coordinateY);
		if (existingCell != null) {
			this.currentCell = existingCell;
		} else {
			this.currentCell = new Cell(Color.WHITE, coordinateX, coordinateY);
		}

	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
}
