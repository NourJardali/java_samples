package sample8;

import java.util.Calendar;

public class TimeSlot {
	private int patientId;
	private int startingHour;
	private Period period;
	
	public TimeSlot() {
		
	}
	
	public TimeSlot(int id, Period period, int hr) {
		this.patientId = id;
		this.startingHour = hr;
		this.period = period;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getStartingHour() {
		return startingHour;
	}

	public void setStartingHour(int startingHour) {
		this.startingHour = startingHour;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
