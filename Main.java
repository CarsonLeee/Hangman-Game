//Name: Carson Lee
//Date: July 1st, 2021
//Description: Hangman Game

package hangman_project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		
		System.out.println("Welcome to the hangman game! The word has been chose, please enter a letter:");
		File dictionary = new File("words.txt");

		Scanner textScanner = new Scanner(dictionary);
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<>();
		while(textScanner.hasNextLine()) {
			words.add(textScanner.nextLine());
		}
		
		String hidden_text = words.get((int)(Math.random() * words.size()));
		char[] textArray = hidden_text.toCharArray();
		int lives = 6;
		char[] answer = new char[textArray.length];
		
		for(int i = 0; i < textArray.length; i++) {
			answer[i] = '?';
		}
		
		boolean complete = false;
		while(complete == false) {
			System.out.println("**************************************************************************");
			String letter = input.next();
			//Checks to make sure value is actually a valid letter
			while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
				System.out.println("Error, please input a valid answer");
				letter = input.next();
			}
			boolean found = false;
			for(int i = 0; i < textArray.length; i++) {
				if(letter.charAt(0) == textArray[i]) {
					answer[i] = textArray[i];
					found = true;
				}
			}
			if(!found) {
				lives--;
				System.out.println("The letter was incorrect, therefore you have lost a life");
			}
			boolean done = true;
			for(int i = 0; i < answer.length; i++) {
				if(answer[i] == '?') {
					System.out.print(" _");
					done = false;
				}else {
					System.out.print(" " + answer[i]);
				}
			}
			System.out.println("\n" + "You have " + lives + " lives left");
			drawHangman(lives);
			if(done) {
				System.out.println("Congratulations, you have solved the word!");
				complete = true;
			}
			
			if(lives <= 0) {
				System.out.print("You are out of lives, you have lost! The word was: " + hidden_text);
				complete = true;
			}
		}
	}
	

	private static void drawHangman(int l) {
		  if(l == 6) {
		   System.out.println("|----------");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 5) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 4) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|    |");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 3) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 2) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 1) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|   /");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else{
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|   /|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
	}

}
