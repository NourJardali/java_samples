package task2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f;
		//initialize frame
				f = new JFrame();
				
				//get number of person to be managed
				int nb = Integer.parseInt(JOptionPane.showInputDialog(f, "How many people should be managed"));
				
				//2-dimensional array
				String arr[][] = new String[nb][3];
				
				String message = "";
				
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
				
				//read data from array
				for(int i = 0; i < nb; i++) {
					String firstName = arr[i][0];
					String lastName = arr[i][1];
					String year = arr[i][2];
					
					//check if divisible by 2
					boolean res = Integer.parseInt(year) % 2 == 0;
					
					message += firstName + " " + lastName + ":";
					if(res) {
						message += "The year of birth is divisible by 2"; 
					}
					else {
						message += "The year of birth is not divisible by 2";
					}
					message += "\n";
				}
				
				//display all entered data
				JOptionPane.showMessageDialog(f,"Persons:\n" + message); 

	}

}
