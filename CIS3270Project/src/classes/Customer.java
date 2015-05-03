package classes;

import java.sql.SQLException;

import flights.FlightsSQL;

public class Customer extends User {

	private String firstName;

	private String lastName;

	private String address;

	private String zip;

	private String state;

	private String email;

	private String ssn;

	private String securityQuestion;

	private String securityAnswer;

	private String city;

	// This secret key allows the program to distinguish between administration
	// users and customers
	private int adminKey;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(int adminKey) {
		this.adminKey = adminKey;
	}

	public boolean book(String flightNumber) throws ClassNotFoundException, SQLException {
	
		boolean booked = false;
		
		FlightsSQL a = new FlightsSQL();
		if ( a.checkBooked(this.getUsername(), flightNumber) == true){
			booked = true;
		
		} else {
			a.bookFlights(this.getUsername(), flightNumber);
		}
		
		return booked;
	}
}
