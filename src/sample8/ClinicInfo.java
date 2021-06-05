package sample8;

public class ClinicInfo {
	private String clinicName;
	private String docName;
	private String address;
	private String phoneNb;
	
	public ClinicInfo() {
		this.clinicName = "";
		this.docName = "";
		this.address = "";
		this.phoneNb = "";
	}
	
	public ClinicInfo(String clinicName, String docName, String address, String phoneNb) {
		this.clinicName = clinicName;
		this.docName = docName;
		this.address = address;
		this.phoneNb = phoneNb;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNb() {
		return phoneNb;
	}

	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;
	}
}
