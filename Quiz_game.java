package javaImpQuestions;
import java.util.*;

public class Quiz_game {

	public static void main(String[] args) {
		
		String[] Questions = {
				
				"1) What is the main funtion of a Router ?",
				"\n2) Which part of the computer is considered as a brain ?",
				"\n3) What year was Facebook launched ?",
				"\n4) Who is known as the father of the Computer ?",
				"\n5) What was the first programming language ?"};
		
		String [][] Options = {
				{"1] Storing files." , "2] Encrypting files. " , "3] Directing Internet Traffic.", "4] Managing Passwords."},
				
				{"1] CPU.", "2] Hard drive.","3] RAM.","4] GPU."},
				
				{"1] 2000.","2] 2004.","3] 2006.","4] 2008.",},
				
				{"1] Steve Jobs.","2] Bill Gates.","3] Allan Turing.","4] Charles Babage."},
				
				{"1] COBOL.","2] C.","3] Fortran.","4] Assembly."},
				};
		
		int [] Answers = { 3,1,2,4,3};
		int score = 0;
		int guess;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("_______________________________");
		System.out.println("| Welcome to Java Quiz game ! |");
		System.out.println("|_____________________________|\n");
		
		for(int i = 0; i< Questions.length; i++) {
			System.out.println(Questions[i]);
			
			for(String options : Options[i]) {
				System.out.println(options);
			}
			
			System.out.print("Enter your guess: ");
			guess = scanner.nextInt();
			
			if(guess == Answers[i]) {
				System.out.println("------------");
				System.out.println("|Correct !!|");
				System.out.println("------------");
				score++;
			}
			
			else {
				System.out.println("------------");
				System.out.println("|Wrong !!  |");
				System.out.println("------------");
			}
		}
		
		System.out.println("\nYour final Score is: " + score *2 + " out of " + Questions.length*2);
		scanner.close();
		}
	}
