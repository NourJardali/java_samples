package sample12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of papers taken from box: ");
		int k = scan.nextInt();
		List<Integer> data = new ArrayList<Integer>();
		boolean isQueue = false;
		boolean isStack = false;
		int j = 0;
		int n = data.size() - 1;
		scan = new Scanner(System.in);
		for(int i = 0; i < k; i++) {
			String line = scan.nextLine();
			String[] cmd = line.split(" ");
			if(cmd[0].equals("A")) {
				data.add(Integer.parseInt(cmd[1]));
				n++;
			}
			else {
				if(data.get(j++) == Integer.parseInt(cmd[1])) {
					isQueue = true;
				}
				else {
					isQueue = false;
					if(data.get(n--) == Integer.parseInt(cmd[1])) {
						isStack = true;
					}
					else {
						isStack = false;
					}
				}
			}
		}
		System.out.println("Enter your guess: queue, stack, not sure, no way!");
		String choice = scan.nextLine();
		if(isStack && isQueue) {
			switch(choice) {
			case "queue":
			case "stack":
				System.out.println("Good Job! It can be either stack or queue");
				break;
			case "not sure":
			case "no way!":
				System.out.println("Wrong guess");
				break;
			}
		}
		else {
			if(isStack) {
				switch(choice) {
				case "stack":
					System.out.println("Good Job! It is definitely a stack");
					break;
				case "queue":
				case "not sure":
				case "no way!":
					System.out.println("Wrong guess");
					break;
				}
			}
			else {
				if(isQueue) {
					switch(choice) {
					case "queue":
						System.out.println("Good Job! It is definitely a queue");
						break;
					case "stack":
					case "not sure":
					case "no way!":
						System.out.println("Wrong guess");
						break;
					}
				}
				else {
					switch(choice) {
					case "not sure":
					case "no way!":
						System.out.println("Good Job! It can not be any of them");
						break;
					case "stack":
					case "queue":
						System.out.println("Wrong guess");
						break;
					}
				}
			}
		}
	}

}
