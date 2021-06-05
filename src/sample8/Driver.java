package sample8;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClinicReservation clinic = new ClinicReservation("MIND Clinics", "Robert", "Hamra", "01748000");
		Patient[] patientRec = new Patient[20];
		int numOfPatient = 0;
		int choice;
		int choice2;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Choose an option from menu below:");
			System.out.println("1- New Patient");
			System.out.println("2- Previous Patient");
			System.out.println("3- Display clinic reservations");
			System.out.println("4- Exit System");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				Patient patient = new Patient();
				System.out.println("Enter your name: ");
				patient.setPatientName(scan.next());
				System.out.println("Enter your age: ");
				patient.setAge(scan.nextInt());
				numOfPatient++;
				patient.setFileNumber(numOfPatient);
				System.out.println("Your file number is = " + patient.getFileNumber());
				patientRec[numOfPatient - 1] = patient;
				System.out.println("Choose an option from menu below:");
				System.out.println("1- Add appointment");
				System.out.println("2- Check appointment");
				System.out.println("3- Delete appointment");
				choice2 = scan.nextInt();
				switch(choice2) {
				case 1:
					int choice3;
					System.out.println("Choose period:");
					System.out.println("1- Morning");
					System.out.println("2- Afternoon");
					System.out.println("3- Evening");
					choice3 = scan.nextInt();
					Period period = null;
					switch(choice3) {
					case 1:
						period = Period.morning;
						break;
					case 2:
						period = Period.afternoon;
						break;
					case 3:
						period = Period.evening;
						break;
					}
					System.out.println("Choose starting hour:");
					int[] times = clinic.getPeriodHours(period);
					for(int i = 0; i < 3; i ++) {
						System.out.println(i + "- " + times[i]);
					}
					int chosenHr = times[scan.nextInt()];
					clinic.reserveSlot(numOfPatient, period, chosenHr);
					break;
				case 2:
					System.out.println("You have an oppointment at " + clinic.getPatientResrvation(numOfPatient));
					break;
				case 3:
					clinic.deleteSlot(numOfPatient);
					break;
				}
				break;
			case 2:
				System.out.println("Enter your file number: ");
				int fileNb = scan.nextInt();
				System.out.println("Choose an option from menu below:");
				System.out.println("1- Add appointment");
				System.out.println("2- Check appointment");
				System.out.println("3- Delete appointment");
				choice2 = scan.nextInt();
				switch(choice2) {
				case 1:
					int choice3;
					System.out.println("Choose period:");
					System.out.println("1- Morning");
					System.out.println("2- Afternoon");
					System.out.println("3- Evening");
					choice3 = scan.nextInt();
					Period period = null;
					switch(choice3) {
					case 1:
						period = Period.morning;
						break;
					case 2:
						period = Period.afternoon;
						break;
					case 3:
						period = Period.evening;
						break;
					}
					System.out.println("Choose starting hour:");
					int[] times = clinic.getPeriodHours(period);
					for(int i = 0; i < 3; i ++) {
						System.out.println((i+1) + "- " + times[i]);
					}
					int chosenHr = times[scan.nextInt()];
					clinic.reserveSlot(numOfPatient, period, chosenHr);
					break;
				case 2:
					int val = clinic.getPatientResrvation(numOfPatient);
					if(val == -1) {
						System.out.println("You don't have an appointment");
					}
					else {
						System.out.println("You have an oppointment at " + val);
					}
					break;
				case 3:
					clinic.deleteSlot(numOfPatient);
					break;
				}
				break;
			case 3:
				clinic.displaySlots();
				break;
			}
		}while(choice != 4);
	}

}
