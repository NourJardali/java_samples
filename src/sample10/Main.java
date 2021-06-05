package sample10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String number;
		do {
			System.out.println("Enter the number in one string: ");
			number = scan.nextLine();
			if(number.equals("-1")) {
				System.out.println("Thank you!");
				break;
			}
			int sum = 0;
			for(int i = 0; i < number.length(); i++) {
				char ch = number.charAt(i);
				if(Character.isDigit(ch)) {
					sum += Character.getNumericValue(ch);
				}
			}
			System.out.println("The total is " + sum);
		}while(true);
	}

}
