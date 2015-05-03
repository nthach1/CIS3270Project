package users;

public abstract class User {

	public String username;

	public String password;

	public abstract  String getUsername();
	public abstract void setUsername(String username);
	public abstract String getPassword();
	public abstract void setPassword(String password) ;

}
