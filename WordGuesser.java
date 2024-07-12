package H1;

import java.util.Random;
import java.util.Scanner;

public class LetterGuesser {
	public static void main(String[] args) {
		String[] words = { "hello", "world", "java", "coding", "game" };
		Random rand = new Random();
		String word = words[rand.nextInt(words.length)];
		int lives = word.length() * 3;

		String display = "";
		for (int i = 0; i < word.length(); i++) {
			display += "_";
		}

		Scanner in = new Scanner(System.in);

		while (lives > 0 && !display.equals(word)) {
			System.out.println("Word: " + display);
			System.out.println("Lives: " + lives);
			System.out.print("Guess a letter: ");
			char guess = in.next().charAt(0);

			boolean found = false;
			String newDisplay = "";
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess) {
					newDisplay += guess;
					found = true;
				} else {
					newDisplay += display.charAt(i);
				}
			}

			if (found) {
				display = newDisplay;
			} else {
				lives--;
				System.out.println("Incorrect guess!");
			}
		}

		if (display.equals(word)) {
			System.out.println("Congratulations! You win!");
		} else {
			System.out.println("Game over! You lose.");
			System.out.println("The word was: " + word);
		}

	}
}
