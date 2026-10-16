import java.util.Scanner;

public class Madlibs {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String color, pastTenseVerb, adjective, noun;
		
		System.out.println("Enter a color");
		color = scnr.next();
		System.out.println("Enter a past tense verb");
		pastTenseVerb = scnr.next();
		System.out.println("Enter an adjective");
		adjective = scnr.next();
		System.out.println("Enter a noun");
		noun = scnr.next();
		
		System.out.print("The " + color + " dragon " + pastTenseVerb + " at the " + adjective
				+ " knight, who rode in on a sturdy, giant " + noun + ".");
		scnr.close();
	}
}