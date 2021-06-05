package sample8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicReservation {
	private ClinicInfo clinicInfo;
	private int[] timeSlots = {9, 10, 11, 14, 15, 16, 18, 19, 20};
	private List<TimeSlot> reservedSlots;
	
	public ClinicReservation() {
		this.clinicInfo = new ClinicInfo();
		reservedSlots = new ArrayList<TimeSlot>();
	}
	
	public ClinicReservation(String clinicName, String docName, String address, String phoneNb) {
		this.clinicInfo = new ClinicInfo(clinicName, docName, address, phoneNb);
		reservedSlots = new ArrayList<TimeSlot>();
	}

	public ClinicInfo getClinicInfo() {
		return clinicInfo;
	}

	public void setClinicInfo(ClinicInfo clinicInfo) {
		this.clinicInfo = clinicInfo;
	}

	public List<TimeSlot> getReservedSlots() {
		return reservedSlots;
	}

	public void setReservedSlots(List<TimeSlot> reservedSlots) {
		this.reservedSlots = reservedSlots;
	}
	
	public int[] getPeriodHours(Period period) {
		int[] times = new int[3];
		if(period == Period.morning) {
			for(int i = 0; i < 3; i++) {
				times[i] = this.timeSlots[i];
			}
		}
		else {
			if(period == Period.afternoon) {
				for(int i = 3; i < 6; i++) {
					times[i - 3] = this.timeSlots[i];
				}
			}
			else {
				for(int i = 6; i < 9; i++) {
					times[i - 6] = this.timeSlots[i];
				}
			}
		}
		return times;
	}
	
	private boolean checkAvailability(int hour) {
		for(TimeSlot time : reservedSlots) {
			if(time.getStartingHour() == hour)
				return false;
		}
		return true;
	}
	
	public void displaySlots() {
		System.out.println("Morning Period: ");
		for(int i = 0; i < 3; i++) {
			boolean res = checkAvailability(timeSlots[i]);
			int endHr = timeSlots[i] + 1;
			System.out.println("[" + timeSlots[i] + ":00-" + endHr + ":00] " + (res == true ? "Available" : "Reserved"));
		}
		
		System.out.println("Afternoon Period: ");
		for(int i = 3; i < 6; i++) {
			boolean res = checkAvailability(timeSlots[i]);
			int endHr = timeSlots[i] + 1;
			System.out.println("[" + timeSlots[i] + ":00-" + endHr + ":00] " + (res == true ? "Available" : "Reserved"));
		}
		
		System.out.println("Evenings Period: ");
		for(int i = 6; i < 9; i++) {
			boolean res = checkAvailability(timeSlots[i]);
			int endHr = timeSlots[i] + 1;
			System.out.println("[" + timeSlots[i] + ":00-" + endHr + ":00] " + (res == true ? "Available" : "Reserved"));
		}
	}
	
	private int getReservedPatient(int hr) {
		for(TimeSlot time : this.reservedSlots) {
			if(time.getStartingHour() == hr)
				return time.getPatientId();
		}
		return 0;
	}
	
	public boolean reserveSlot(int patientId, Period period, int startingHr) {
		if(!checkAvailability(startingHr)) {
			if(getReservedPatient(startingHr) == patientId) {
				System.out.println("This patient already has a reservation in that selected slot");
				return false;
			}
			System.out.println("This slot is not available");
			return false;
		}
		reservedSlots.add(new TimeSlot(patientId, period, startingHr));
		System.out.println("Reserved Successfully");
		return true;
	}
	
	public void deleteSlot(int patientId) {
		List<TimeSlot> temp = new ArrayList<TimeSlot>();
		for(TimeSlot time : reservedSlots) {
			if(patientId == time.getPatientId()) {
				temp.add(time);
			}
		}
		if(temp.size() == 0) {
			System.out.println("No reserved slots for this patient");
		}
		else {
			if(temp.size() == 1) {
				reservedSlots.remove(temp.get(0));
				System.out.println("Reserved slot deleted successfully for patient " + patientId);
			}
			else {
				System.out.println("Several reserved slots found for patient " + patientId);
				System.out.println("which one you would like to delete: ");
				for(TimeSlot time : temp) {
					System.out.println("at " + time.getStartingHour());
				}
				Scanner scan = new Scanner(System.in);
				int hr = scan.nextInt();
				for(TimeSlot time : temp) {
					if(time.getStartingHour() == hr) {
						reservedSlots.remove(time);
						System.out.println("Reserved slot deleted successfully for patient " + patientId + " at Slot [" + time.getStartingHour() + ":00-" + (hr + 1) + ":00]");
						break;
					}
				}
			}
		}
	}
	
	public int getPatientResrvation(int patientId) {
		for(TimeSlot time : this.reservedSlots) {
			if(time.getPatientId() == patientId) {
				return time.getStartingHour();
			}
		}
		return -1;
	}
}
