package poke;

import java.util.Scanner;

public class Pokemon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] creatures = { "Firebeast", "Waterwhale", "Grassgoat" };
		int[] health = { 100, 120, 110 };

		String[][] attackNames = { { "Flame Burst", "Fire Claw", "Inferno" },
				{ "Water Splash", "Aqua Punch", "Tidal Wave" }, { "Leaf Whip", "Vine Smash", "Nature Fury" } };
		int[][] attackPower = { { 20, 15, 25 }, { 15, 10, 20 }, { 18, 12, 22 } };

		System.out.println("Choose your creature");
		System.out.println("1. Firebeast");
		System.out.println("2. Waterwhale");
		System.out.println("3. Grassgoat");
		System.out.println("Enter the number of your choice: ");
		int playerChoice = scanner.nextInt() - 1;

		int opponentChoice = (int) (Math.random() * creatures.length);

		while (opponentChoice == playerChoice) {
			opponentChoice = (int) (Math.random() * creatures.length);

		}

		System.out.println("\nYou chose " + creatures[playerChoice] + "!");
		System.out.println("Your opponent is " + creatures[opponentChoice] + "!\n");

		int playerHealth = health[playerChoice];
		int opponentHealth = health[opponentChoice];
		boolean playerTurn = true;

		while (playerHealth > 0 && opponentHealth > 0) {
			if (playerTurn) {
				System.out.println("\nChoose your attack:");
				for (int i = 0; i < attackNames[playerChoice].length; i++) {
					System.out.println((i + 1) + ". " + attackNames[playerChoice][i] + "(Power:"
							+ attackPower[playerChoice][i] + ")");
				}
				System.out.println("Enter the number of your attack: ");
				int attackChoice = scanner.nextInt() - 1;
			} else {
				int opponentAttack = (int) (Math.random() * attackNames[opponentChoice].length);
				System.out.println(
						creatures[opponentChoice] + " used " + attackNames[opponentChoice][opponentAttack] + "!");
				playerHealth -= attackPower[opponentChoice][opponentAttack];
				System.out.println("Your health:" + playerHealth);
			}

			playerTurn = !playerTurn;
		}
		if (playerHealth <= 0) {
			System.out.println("\nOh no! You were defeated by " + creatures[opponentChoice] + "!");
		} else {
			System.out.println("\nCongratulation! You defeated " + creatures[opponentChoice] + "!");
		}
		scanner.close();
	}
}
