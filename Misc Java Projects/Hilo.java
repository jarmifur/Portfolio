import java.util.Scanner;

public class Hilo {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			int num = (int)(Math.random() * 100 + 1);
			int userNum = 0, numTries = 0;
			
			while (userNum != num) {
				System.out.println("Guess a number between 1 and 100.");
				
				userNum = scnr.nextInt();
				
				if (userNum > num) {
					System.out.println(userNum + " is too high. Try again.");
				}
				else if (userNum < num) {
					System.out.println(userNum + " is too low. Try again.");
				}
				numTries++;
			}
			System.out.println(num + " is correct! You win!");
			System.out.println("It only took you " + numTries + " tries! Good work!");
			System.out.println("Would you like to play again (y/n)?");
			
			choice = scnr.next();
		}
		System.out.println("Thanks for playing!");
		scnr.close();
	}
}