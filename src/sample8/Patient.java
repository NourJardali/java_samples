package sample8;

public class Patient {
	private String patientName;
	private int fileNumber;
	private int age;
	private String history;
	
	public Patient() {
		this.patientName = "";
		this.fileNumber = 0;
		this.age = 0;
		this.history = "";
	}
	
	public Patient(String name, int nb, int age, String history) {
		this.patientName = name;
		this.fileNumber = nb;
		this.age = age;
		this.history = history;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
}
