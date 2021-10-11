package com.exercise.demo.entity;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Cell> blackCells;
	private GridPointer pointer;

	public Grid() {
		Cell startposition = new Cell(Color.WHITE, 0, 0);
		this.blackCells = new ArrayList<>();
		this.blackCells.add(startposition);
		this.pointer = new GridPointer(startposition);
	}

	public GridPointer getPointer() {
		return pointer;
	}

	public void setPointer(GridPointer pointer) {
		this.pointer = pointer;
	}

	public ArrayList<Cell> getBlackCells() {
		return blackCells;
	}

	public Cell findBlackCell(int coordinateX, int coordinateY) {
		for (Cell cell : this.blackCells) {
			if (cell.getCoordinateX() == coordinateX && cell.getCoordinateY() == coordinateY) {
				return cell;
			}
		}
		return null;
	}

	public void addBlackCell(Cell cell) {
		Cell foundCell = this.findBlackCell(pointer.getCurrentCell().getCoordinateX(),
				pointer.getCurrentCell().getCoordinateY());
		if (foundCell != null) {
			this.blackCells.remove(foundCell);
		}
		this.blackCells.add(cell);
	}

	public void removeBlackCell(Cell cell) {
		Cell foundCell = this.findBlackCell(cell.getCoordinateX(), cell.getCoordinateY());

		if (foundCell != null) {
			this.blackCells.remove(foundCell);
		}
	}
}
