package sample9;

import java.util.Scanner;

public class Main {
	public static String validateNumber() {
		System.out.println("Enter a phone number: ");
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		String result = "";
		String regex = "^^([0-9]{8})|((\\([\\d]{3}\\))[\\d]{5})|((\\([\\d]{3}\\))[\\d]{3}[-][\\d]{2})|(([\\d]{3})[-][\\d]{5})$$";
		if(number.matches(regex)) {
			for(int i = 0; i < number.length(); i++) {
				char ch = number.charAt(i);
				if(ch != '(' && ch != ')' && ch != '-') {
					result += ch;
				}
			}
			return result;
		}
		else {
			return "None";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = validateNumber();
		if(result.equals("None")) {
			System.out.println("Invalid Number");
		}
		else {
			System.out.println("Your number is " + result + ", Thanks!");
		}
	}

}
