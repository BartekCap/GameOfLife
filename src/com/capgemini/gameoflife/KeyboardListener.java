package com.capgemini.gameoflife;

import java.util.Scanner;

public class KeyboardListener {
	
	private Scanner scanner;
	
	public String getInput(){
		String input;
		scanner = new Scanner(System.in);
		input= scanner.nextLine();
		return input;
	}
}
