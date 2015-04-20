package users;

public abstract class User {

	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String zip;
	
	private String state;
	
	private String email;
	
	private String ssn;
	
	private String securityQuestion;
	
	private String securityAnswer;
	
	private int adminKey;

	private String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	private String getZip() {
		return zip;
	}

	private void setZip(String zip) {
		this.zip = zip;
	}

	private String getState() {
		return state;
	}

	private void setState(String state) {
		this.state = state;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getSsn() {
		return ssn;
	}

	private void setSsn(String ssn) {
		this.ssn = ssn;
	}

	private String getSecurityQuestion() {
		return securityQuestion;
	}

	private void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	private String getSecurityAnswer() {
		return securityAnswer;
	}

	private void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
}
