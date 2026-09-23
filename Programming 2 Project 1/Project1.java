import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Processes a list of names and provides various operations through a menu based program.
 */

public class Project1 {
	
	public static String[] getNames(Scanner scnr) {
		System.out.println("Enter List of Names Separated by Commas:");
		
		String input = scnr.nextLine();
		
		return input.split(",");
	}
	
	/** 
	 * Displays menu to the user.
	 */
	
	public static void printMenu() {
		System.out.println("1) Display List Ordered");
		System.out.println("2) Display Full Names");
		System.out.println("3) Display Single Names");
		System.out.println("4) Display Name Statistics");
		System.out.println("5) Display Names with Even Length");
		System.out.println("6) Display Names with Odd Length");
		System.out.println("7) Display Names not Capitalized");
		System.out.println("8) Display Most Frequent Name");
		System.out.println("9) Enter new list of Names");
		System.out.println("0) Quit Program");
	}
	
	/**
	 * Displays the names in alphabetical order without changing the original capitalization.
	 * 
	 * @param names array of names to sort and display
	 */
	
	public static void option1(String[] names ) {
		Arrays.sort(names, Comparator.comparing((String s) -> Character.toLowerCase(s.trim().charAt(0)))
				.thenComparing(String.CASE_INSENSITIVE_ORDER)
				);
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
	
	/**
	 * Displays only the names containing a space
	 * 
	 * @param names array of names to check
	 */
	
	public static void option2(String[] names) {
			
		for (String name : names) {
			if (name.contains(" ")) {
				System.out.println(name);
			}
		}
	}
	
	/**
	 * Displays only names that do not contain a space
	 * @param names array of names to check
	 */
	
	public static void option3(String[] names) {
		for(String name : names) {
			if (name.contains(" ") == false) {
				System.out.println(name);
			}
		}
	}
	
	/**
	 * Displays statistics about the input list of names, including name count, total letter count, average length, shortest name, longest name, 
	 * and population standard deviation
	 * @param names array of names used for calculations
	 */
	
	public static void option4(String[] names) {
		
		int totalLetters = 0;
		double averageLength;
		double variance = 0;
		double standardDeviation;
		String shortest = names[0];
		String longest = names[0];
		
		System.out.println("Name Count: " + names.length);
		
		//Total Letters
		for (String name : names) {
			totalLetters += name.replace(" ", "").length();
		}
		System.out.println("Letter Count Total: " + totalLetters);
		
		//Average Length
		averageLength = (double)totalLetters / names.length;		
		System.out.printf("Avg Name Length: %.2f%n", averageLength);
		
		//Shortest Name
		for (String name : names) {
			if (name.replace(" ", "").length() < shortest.replace(" ", "").length()) {
				shortest = name;
			}
		}
		System.out.println("Shortest Name: " + shortest);
		
		//Longest Name
		for (String name : names) {
			if (name.replace(" ", "").length() > longest.replace(" ", "").length()) {
				longest = name;
			}
		}
		System.out.println("Longest Name: " + longest);
		
		//Standard Deviation
		for (String name : names) {
			variance += Math.pow(name.replace(" ", "").length() - averageLength, 2);
		}
		variance = variance / names.length;
		standardDeviation = Math.sqrt(variance);
		System.out.printf("Population Standard Deviation: %.2f%n", standardDeviation);
	}
	
	/**
	 * Displays names with an even length excluding spaces
	 * @param names array of names to check
	 */
	
	public static void option5(String[] names) {
		for (String name : names) {
			if (name.replace(" ", "").length() % 2 == 0) {
				System.out.println(name);
			}
		}
	}
	
	/**
	 * Displays names with an odd length excluding spaces
	 * @param names array of names to check
	 */
	
	public static void option6(String[] names) {
		for (String name : names) {
			if (name.replace(" ", "").length() % 2 == 1) {
				System.out.println(name);
			}
		}
	}
	
	/**
	 * Displays every word that does not begin with an uppercase letter, full names evaluated one word at a time.
	 * @param names array of names to check
	 */
	
	public static void option7(String[] names) {
		for (String name : names) {
			String[] words = name.split(" ");
			
			for (String word : words) {
				if (!Character.isUpperCase(word.charAt(0))) {
					System.out.println(word);
				}
			}
		}
	}
	
	/**
	 * Determines and displays the name which occurs most in the list using case-insensitive comparison.
	 * @param names array of names to check
	 */
	
	public static void option8(String[] names) {
		String modeName = names[0];
		int highestCount = 0;
		
		for (String name : names) {
			int count = 0;
			
			for (String otherName : names) {
				if (name.equalsIgnoreCase(otherName)) {
					count++;
				}
			}
			
			if (count > highestCount) {
				highestCount = count;
				modeName = name;
			}
		}
		if (highestCount == 1) {
			System.out.println("No most frequent name");
		}
		else {
			System.out.println("Most Frequent Name: " + modeName);
		}		
	}
	
	/**
	 * Gets a new list of names from the user
	 * @param scnr Scanner used to read input
	 * @return an array containing the new list of names
	 */
	
	public static String[] option9(Scanner scnr) {
		return getNames(scnr);
	}
	
	/**
	 * Runs the list program until the user enters 0
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String[] names = getNames(scnr);
		
		int userChoice = -1;
		
		while (userChoice != 0) {
			printMenu();
			userChoice = scnr.nextInt();
			scnr.nextLine();
			
			if (userChoice == 1) {
				option1(names);
			}
			else if (userChoice == 2) {
				option2(names);
			}
			else if (userChoice == 3) {
				option3(names);
			}
			else if (userChoice == 4) {
				option4(names);
			}
			else if (userChoice == 5) {
				option5(names);
			}
			else if (userChoice == 6) {
				option6(names);
			}
			else if (userChoice == 7) {
				option7(names);
			}
			else if (userChoice == 8) {
				option8(names);
			}
			else if (userChoice == 9) {
				names = option9(scnr);
			}
			else if (userChoice != 0) {
				System.out.println("Choice must be in range 0-9");
			}
		}
	}
}