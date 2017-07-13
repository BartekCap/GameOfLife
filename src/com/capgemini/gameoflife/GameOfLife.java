package com.capgemini.gameoflife;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameOfLife {

	private static Pattern inputPattern = Pattern.compile("[1-9][0-9]{0,2}");
	private int rows;
	private int columns;

	public void play() {
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.startGameOfLife();
	}
	
	public int validateStringAndGetInt(KeyboardListener keyboardListener){
		String rowOrColumnString;
		do {
			rowOrColumnString = keyboardListener.getInput();
			if(checkRegex(rowOrColumnString)!=true){
				PrintUtility.printStatementForBadInsertedValue();
			}
			
		} while (checkRegex(rowOrColumnString) != true);
		return Integer.parseInt(rowOrColumnString);
	}
	
	private void startGameOfLife() {
		askForRowsAndColumns();
		GameService gameService= new GameService(new BoardOfCells(rows, columns));
		gameService.startGameService();
	}

	private void askForRowsAndColumns() {
		KeyboardListener keyboardListener = new KeyboardListener();
		getInputForRows(keyboardListener);
		getInputForColumns(keyboardListener);
	}

	private void getInputForColumns(KeyboardListener keyboardListener) {
		PrintUtility.printStatementForInsertingColumns();
		this.columns=validateStringAndGetInt(keyboardListener);
	}

	private void getInputForRows(KeyboardListener keyboardListener) {
		PrintUtility.printStatementForInsertingRows();
		this.rows = validateStringAndGetInt(keyboardListener);
	}
	
	private boolean checkRegex(String rowString) {
		Matcher matcher = inputPattern.matcher(rowString);
		return matcher.matches();
	}

}