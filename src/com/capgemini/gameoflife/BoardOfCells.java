package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class BoardOfCells {
	
	private Cell[][] cellArray;
	private final int rows;
	private final int columns;
	private List<Cell> listOfAllCells;
	
	public BoardOfCells(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		cellArray = new Cell[rows][columns];
		initializeAllOfCells();
	}

	public void generateRandomStateForAllCells(){
		for(Cell c: listOfAllCells){
			c.generateRandomState();
		}
	}
	
	private void initializeAllOfCells() {
		listOfAllCells = new ArrayList<>();
		for(int iteratorRow=0; iteratorRow<rows;iteratorRow++){
			for(int iteratorColumn=0;iteratorColumn<columns;iteratorColumn++){
				cellArray[iteratorRow][iteratorColumn]= new Cell(iteratorRow,iteratorColumn);
				listOfAllCells.add(cellArray[iteratorRow][iteratorColumn]);
			}
		}
	}
	
	public Cell[][] getCellArray() {
		return cellArray;
	}
	public void setCellArray(Cell[][] cellArray) {
		this.cellArray = cellArray;
	}
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public List<Cell> getListOfAllCells() {
		return listOfAllCells;
	}
	public void setListOfAllCells(List<Cell> listOfAllCells) {
		this.listOfAllCells = listOfAllCells;
	}
}
