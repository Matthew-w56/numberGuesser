package com.matt;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberGuesserApp {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean going = true;
		int corrects = 0, total = 0;
		DecimalFormat df2 = new DecimalFormat(".##");
		AnswerPool pool = new AnswerPool();
		
		System.out.println("Get a friend and tell them to give you a number (between 0-10)");
		System.out.println("I'm going to try to guess the next number they will");
		System.out.println("say based off of the last one they said");
		System.out.println("enter \"q\" to exit the program, and \"i\" to get info");
		
		int guess;
		String in; int num = -1, lastGuess = -1, lastNum = -1;
		while (going) {
			System.out.println("----------------------");
			System.out.print("> ");
			in = scanner.nextLine();
			if (in.equalsIgnoreCase("i")) {
				System.out.println("I have gotten " + corrects + " correct.");
				System.out.println("That's out of " + total + " total tries");
				if (total != 0) {
					double percentage = ((double)corrects / (double)total) * 100;
					System.out.println("So I've gotten " + df2.format(percentage) + " percent correct!");
				}
				
			} else if (in.equalsIgnoreCase("q")) {
				going = false;
				break;
			} else {
				try {
					num = Integer.parseInt(in);
					total ++;
					if (num > -1 && num < 11) {
						if (lastGuess != -1) {
							if (num == lastGuess) {
								corrects ++;
								System.out.println("I got it correct then!");
							} else {
								System.out.println("Dang, maybe next time..");
							}
							pool.store(lastNum, num);
						} else {
							System.out.println("Good start.  Next?");
						}
					} else {
						System.out.println("That isn't in the range!");
					}
				} catch (NumberFormatException e) {
					System.out.println("I'm not sure what to do with that input, so I shall do nothing.");
				}
			}
			
			if (num > -1 && num < 11) {
				guess = pool.getGuess(num);
				System.out.println("My next guess is: " + guess);
				lastNum = num;
				lastGuess = guess;
			}
			
		}
		
		System.out.println("Goodbye!");
		
		scanner.close();
	}
}
