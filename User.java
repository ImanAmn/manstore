import java.util.*;

public class User {
	public String username;
	public String pass; // TODO: private pass...
	public final String birthdate;
	public String phoneNumber;
	public int id;

	public User(String username, String pass, String birthdate, String phoneNumber) {
		this.username = username;
		this.pass = pass;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
	}
}
