package com.capgemini.gameoflife;

public class Cell {

	private static final String STRING_IF_ALIVE = "[x]";
	private static final String STRING_IF_DEAD ="[ ]";
	private int row;
	private int column;
	private int numberOfAliveNeighbors;
	private Boolean state;
	private Boolean tempState;

	public Cell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public void generateRandomState() {
		this.state = Math.random() < 0.5;
		this.tempState=this.state;
	}
	
	@Override
	public String toString() {
		String stringToDisplay;
		if(state){
			stringToDisplay=STRING_IF_ALIVE;
		}
		else{
			stringToDisplay=STRING_IF_DEAD;
		}
		return stringToDisplay;
	}

	public Boolean getTempState() {
		return tempState;
	}
	public void setTempState(Boolean tempState) {
		this.tempState = tempState;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getNumberOfAliveNeighbors() {
		return numberOfAliveNeighbors;
	}
	public void setNumberOfAliveNeighbors(int numberOfAliveNeighbors) {
		this.numberOfAliveNeighbors = numberOfAliveNeighbors;
	}
}
