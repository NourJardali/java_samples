package hidden_msg;

import java.util.Scanner;

public class HiddenMsg {
	
	public static int replace(String message, int i) {
		if(i == message.length())
			return 0;
		if(!message.contains("#"))
			return 1;
		if(message.charAt(i) == '#') {
			if(i == 0) {
				String newMsg = "";
				newMsg += message.charAt(i+1);
				newMsg += message.substring(i+1);
				return replace(newMsg, i+1);
			}
			if(i == message.length() - 1) {
				String newMsg = message.substring(0, i-1);
				newMsg += message.charAt(i - 1);
				return replace(newMsg, i+1);
			}
			String newMsg1 = message.substring(0, i);
			String newMsg2 = message.substring(0, i);
			newMsg1 += message.charAt(i-1);
			for(int j = i+1; j < message.length(); j++) {
				if(message.charAt(j) != '#') {
					newMsg2 += message.charAt(j);
					break;
				}
			}
			newMsg1 += message.substring(i+1);
			newMsg2 += message.substring(i+1);
			if(newMsg1.equals(newMsg2))
				return replace(newMsg1, i+1);
			return replace(newMsg1, i+1) + replace(newMsg2, i+1);
		}
		return replace(message, i+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String message;
		do {
			System.out.println("Enter a message, enter -1 to stop: ");
			message = scan.next();
			System.out.println(replace(message, 0) + "");
		}while(!message.equals("-1"));
	}

}
