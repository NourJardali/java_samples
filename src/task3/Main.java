package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	static int nb;
	static int[] readBirthDate() {
		BufferedReader reader;
		int arr[] = new int[nb];
		try {
			reader = new BufferedReader(new FileReader("PersonBirthdate.txt"));
			String line = reader.readLine();
			int i = 0;
			//read each line
			while(line != null) {
				arr[i] = Integer.parseInt(line);
				i++;
				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			JFrame f;
			f = new JFrame();
			//display error message
			JOptionPane.showMessageDialog(f,"Error reading!"); 
		}
		return arr;
	}
	
	static void giveBirthDateOff(int arr[], int i) {
		JFrame f;
		f = new JFrame();
		//display data
		JOptionPane.showMessageDialog(f,"The person's date of birth is: " + arr[i]); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f;
		//initialize frame
				f = new JFrame();
				
				//get number of person to be managed
				int nb = Integer.parseInt(JOptionPane.showInputDialog(f, "How many people should be managed"));
				
				//2-dimensional array
				String arr[][] = new String[nb][3];
				
				//ask user to enter data for these people
				for(int i = 0; i < nb; i++) {
					int n = i+1;
					String firstName = JOptionPane.showInputDialog(f, "First name of person " + n);
					String lastName = JOptionPane.showInputDialog(f, "Surname of person " + n);
					String year = JOptionPane.showInputDialog(f, "Year of birth represents person" + n);
					
					//fill data in 2-dimensional array
					arr[i][0] = firstName;
					arr[i][1] = lastName;
					arr[i][2] = year;
				}
				
				//suppose file is given
				String bornDateSign = JOptionPane.showInputDialog(f, "Born date sign");
				int dates[] = readBirthDate();
				giveBirthDateOff(dates, Integer.parseInt(bornDateSign));
				
	}

}
