package com.capgemini.gameoflife;

import java.util.Arrays;

public class PrintUtility {
	
	public static void printBoardOfCells(BoardOfCells boardOfCells){
		Cell[][] cellsArray = boardOfCells.getCellArray();
		
		for (int iteratorRow = 0; iteratorRow < boardOfCells.getRows(); iteratorRow++) {
			System.out.println(Arrays.deepToString(cellsArray[iteratorRow]));
		}
		System.out.println("--------------------------------------------------------------------------");
	}

	public static void printStatmentForKeyboardGame() {
		System.out.println("Wciskaj ENTER aby wygenerowac nowy stan planszy, LUB "
				+ "wcisnij DOWOLNY KLAWISZ i zatwierdz aby zakonczyc");
	}
	
	public static void printStatmentForChoosingVariant(){
		System.out.println(": \n1 - Gra w pętli \n 2 - gra za pomocą klawiatury:"
				+"Wybierz wariant gry (wprowadz cyfrę i zatwierdź enterem): ");
	}
	
	public static void printStatementForInsertingWrongKey(){
		System.out.println("Wprowadzone dane są złe. Zrestartuj program i spróbuj ponownie.");
	}
	
	public static void printStatementForInsertingRows(){
		System.out.println("Wprowadź ilość wierszy (min 1 max 200): ");
	}
	
	public static void printStatementForInsertingColumns(){
		System.out.println("Wprowadź ilość kolumn: ");
	}
	
	public static void printStatementForGoodInsertedValue(){
		System.out.println("Wprowadzono poprawną wartość");
	}
	public static void printStatementForBadInsertedValue(){
		System.out.println("Wprowadzono niepoprawną wartość, wprowadź jeszcze raz: ");
	}
}
