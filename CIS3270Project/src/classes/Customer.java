package classes;

import java.sql.SQLException;

import flights.SearchFlightsSQL;

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
	// users and customers. 0 = customer, 1 = administrator
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

	
	// method to check if the customer has booked the flight
	public boolean isBooked(String flightNumber) throws ClassNotFoundException, SQLException {
	
		boolean booked = false;
		
		SearchFlightsSQL a = new SearchFlightsSQL();
		if ( a.checkBooked(this.getUsername(), flightNumber) == true){
			booked = true;
		
		} 
		return booked;
		
		
	}
	
	//method to book flight
	public void book(String flightNumber) throws ClassNotFoundException, SQLException {
		
		
		SearchFlightsSQL a = new SearchFlightsSQL();
		
			a.bookFlights(this.getUsername(), flightNumber);
		
		
	}

	@Override
	public String getUsername() {
		
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
		
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
		
	}
}
