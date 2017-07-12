package com.capgemini.gameoflife;

public class GameService {

	private final int rows;
	private final int columns;
	private BoardOfCells boardOfCells;
	private Cell[][] cellsArray;

	public GameService(BoardOfCells boardOfCells) {
		super();
		this.setBoardOfCells(boardOfCells);
		cellsArray = boardOfCells.getCellArray();
		rows = boardOfCells.getRows();
		columns = boardOfCells.getColumns();
	}
	
	public void startGameService() {
		Boolean userWantToPlay = true;
		PrintUtility.printStatmentForKeyboardGame();
		prepareToPlay();
		playInKeyboardLoop(userWantToPlay);
	}

	private void prepareToPlay() {
		generateRandomState();
	}
	
	private void oneLoopForPlayMethod() {
		forAllCellsCalculateNumberOfAliveNeighbors();
		refreshStatesOfCells();
		PrintUtility.printBoardOfCells(boardOfCells);
	}
	
	private void generateRandomState() {
		boardOfCells.generateRandomStateForAllCells();
	}

	private void playInKeyboardLoop(Boolean userWantToPlay) {
		KeyboardListener keyboardListener = new KeyboardListener();
		do {
			String input = keyboardListener.getInput();
			userWantToPlay = keyboardCondition(userWantToPlay, input);
		} while (userWantToPlay);
	}

	private Boolean keyboardCondition(Boolean userWantToPlay, String input) {
		if (input.equals("")) {
			oneLoopForPlayMethod();
		} else {
			userWantToPlay = false;
		}
		return userWantToPlay;
	}


	private void refreshStatesOfCells() {
		setTempStateUsingGameOfLifeCondition();
		setStateFromTempState();
	}

	private void setTempStateUsingGameOfLifeCondition() {
		for (int iteratorRow = 0; iteratorRow < rows; iteratorRow++) {
			for (int iteratorColumn = 0; iteratorColumn < columns; iteratorColumn++) {
				Boolean state = cellsArray[iteratorRow][iteratorColumn].getState();
				int numberOfAliveNeighbors = cellsArray[iteratorRow][iteratorColumn].getNumberOfAliveNeighbors();
				gameOfLifeConditionSetingTempState(iteratorRow, iteratorColumn, state, numberOfAliveNeighbors);
			}
		}
	}

	private void setStateFromTempState() {
		for (int iteratorRow = 0; iteratorRow < rows; iteratorRow++) {
			for (int iteratorColumn = 0; iteratorColumn < columns; iteratorColumn++) {
				cellsArray[iteratorRow][iteratorColumn]
						.setState(cellsArray[iteratorRow][iteratorColumn].getTempState());
			}
		}
	}

	private void gameOfLifeConditionSetingTempState(int iteratorRow, int iteratorColumn, Boolean state,
			int numberOfAliveNeighbors) {
		if (state == true) {
			if (numberOfAliveNeighbors < 2) {
				cellsArray[iteratorRow][iteratorColumn].setTempState(false);
			} else if (numberOfAliveNeighbors > 3) {
				cellsArray[iteratorRow][iteratorColumn].setTempState(false);
			} else {
				cellsArray[iteratorRow][iteratorColumn].setTempState(true);
			}
		} else {
			if (numberOfAliveNeighbors == 3) {
				cellsArray[iteratorRow][iteratorColumn].setTempState(true);
			}
		}
	}

	private void forAllCellsCalculateNumberOfAliveNeighbors() {

		for (int iteratorRow = 0; iteratorRow < rows; iteratorRow++) {
			for (int iteratorColumn = 0; iteratorColumn < columns; iteratorColumn++) {
				cellsArray[iteratorRow][iteratorColumn].setNumberOfAliveNeighbors(0);
				checkNeighborStateAndConcatenateNumberOfAliveNeighbors(iteratorRow, iteratorColumn);
			}
		}
	}

	private void checkNeighborStateAndConcatenateNumberOfAliveNeighbors(int checkingRow, int checkingColumn) {
		if (checkingRow == 0 && checkingColumn == 0) {
			concatenateNumberOfAliveNeighbors(0, 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, 0, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, 1, checkingRow, checkingColumn);
		} else if (checkingRow == rows - 1 && checkingColumn == columns - 1) {
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn - 1, checkingRow, checkingColumn);
		} else if (checkingRow == 0 && checkingColumn == columns - 1) {
			concatenateNumberOfAliveNeighbors(1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(0, checkingColumn - 1, checkingRow, checkingColumn);
		} else if (checkingRow == rows - 1 && checkingColumn == 0) {
			concatenateNumberOfAliveNeighbors(checkingRow - 1, 0, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, 1, checkingRow, checkingColumn);
		} else if (checkingColumn == 0) {
			concatenateNumberOfAliveNeighbors(checkingRow - 1, 0, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, 0, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, 1, checkingRow, checkingColumn);
		} else if (checkingColumn == columns - 1) {
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, checkingColumn - 1, checkingRow, checkingColumn);
		} else if (checkingRow == 0) {
			concatenateNumberOfAliveNeighbors(0, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(0, checkingColumn + 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(1, checkingColumn + 1, checkingRow, checkingColumn);
		} else if (checkingRow == rows - 1) {
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn + 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn + 1, checkingRow, checkingColumn);
		} else {
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow - 1, checkingColumn + 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow, checkingColumn + 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, checkingColumn - 1, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, checkingColumn, checkingRow, checkingColumn);
			concatenateNumberOfAliveNeighbors(checkingRow + 1, checkingColumn + 1, checkingRow, checkingColumn);
		}
	}

	private void concatenateNumberOfAliveNeighbors(int neighborsRow, int neighborsColumn, int concatenatingCellRow,
			int concatenatingCellColumn) {
		if (cellsArray[neighborsRow][neighborsColumn].getState()) {
			cellsArray[concatenatingCellRow][concatenatingCellColumn].setNumberOfAliveNeighbors(
					cellsArray[concatenatingCellRow][concatenatingCellColumn].getNumberOfAliveNeighbors() + 1);
		}
	}

	public BoardOfCells getBoardOfCells() {
		return boardOfCells;
	}

	public void setBoardOfCells(BoardOfCells boardOfCells) {
		this.boardOfCells = boardOfCells;
	}
}
