package javaImpQuestions;

import java.util.Random;
import java.util.Scanner;

public class Rock_paper_scissor_game {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		String [] choices = {"rock","paper","scissor"};
		String  playerChoice ;
		String  botChoice;
		String  playAgain = null;
		int playerScore = 0;
		int botScore = 0;
		
		do {
			
			System.out.print("\nEnter your choice (rock , paper , scissor)");
			playerChoice = scanner.nextLine();
			
			if(!playerChoice.equals("rock") &&
					!playerChoice.equals("paper") &&
					!playerChoice.equals("scissor")) {
				System.out.println("Invalid choice Try again !!!");
				continue;
			}
			
			botChoice = choices[random.nextInt(3)];
			System.out.println("\nComputer choice: " + botChoice);
			System.out.println("Player choice: " + playerChoice);
			
			if(playerChoice.equals(botChoice)) {
				System.out.println("\nIt's a Tie ! Try again.");
				
				System.out.println("\nPlayer score: "+playerScore);
				System.out.println("\nBot score: "+botScore);
			}
			
			else if(
					(playerChoice.equals("rock") && botChoice.equals("scissor")) ||
					(playerChoice.equals("paper") && botChoice.equals("rock")) ||
					playerChoice.equals("scissor") && botChoice.equals("paper")) {
					
				System.out.println("Congratulations!! You Win :) ");
				playerScore++;
				
				System.out.println("\nPlayer score: "+playerScore);
				System.out.println("\nBot score: "+botScore);
			}

			else {
				System.out.println("You Lose ! Try again.");
				botScore++;
				
				System.out.println("\nPlayer score: "+playerScore);
				System.out.println("\nBot score: "+botScore);
			}
			
			System.out.print("\nPlay again ? (Y/N)");
			playAgain = scanner.nextLine().toUpperCase();
			
		}
		
		while(playAgain.equals("Y"));
		
		System.out.println("Thanks for Playing :) ");
		
	scanner.close();
	}

}
