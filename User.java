package MovieTicketBooking;
import java.util.*; 

public class User {
	private String firstname; 
	private String lastname; 
	private String email; 
	private long phonenumber; 
	private String status = "active"; 
	public User(String firstname, String lastname, String email, long phonenumber, String status) {
		this.firstname = firstname; 
		this.lastname = lastname; 
		this.email=email; 
		this.phonenumber = phonenumber; 
		this.status = status; 
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.contains("@") && email.contains(".")) {
			this.email=email; 
		}else {
			System.out.println("Please enter a valid email"); 
		}
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		String sphn = String.toValue(phonenumber); 
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
