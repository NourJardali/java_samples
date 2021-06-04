package sample1;

import java.util.Scanner;

public class Encrypted {
	private String keyType;
	private int keyNumber;
	
	public Encrypted() {
		keyType = "add";
		keyNumber = 1;
	}
	
	public String getKeyType() {
		return keyType;
	}


	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}


	public int getKeyNumber() {
		return keyNumber;
	}


	public void setKeyNumber(int keyNumber) {
		this.keyNumber = keyNumber;
	}

	public String encrypt(String message) {
		String temp = "";
		for(int i = 0; i < message.length(); i++) {
			int asciiVal = message.charAt(i);
			switch(this.keyType) {
			case "add":
				asciiVal += this.keyNumber;
				break;
			case "subtract":
				asciiVal -= this.keyNumber;
				break;
			}
			temp += ((char) asciiVal);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encrypted encrypted = new Encrypted();
		System.out.println("Enter the key type: ");
		Scanner scan = new Scanner(System.in);
		String keyType = scan.next();
		encrypted.setKeyType(keyType);
		System.out.println("Enter the key integer value: ");
		int keyNumber = scan.nextInt();
		encrypted.setKeyNumber(keyNumber);
		System.out.println("Enter your password for encryption: ");
		String pass = scan.next();
		System.out.println("Your encrypted password is: " + encrypted.encrypt(pass));
	}

}
