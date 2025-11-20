package MovieTicketBooking;

public class User {
    
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private long phonenumber;
    private String password;
    private String status = "active";   // default
 // inside User class
    public User(String firstname, String lastname, String email, long phonenumber, String password, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
        this.status = status;
    }


    // ID getter/setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // toString (prints one full user line)
    @Override
    public String toString() {
        return "User [id=" + id + 
               ", firstname=" + firstname + 
               ", lastname=" + lastname + 
               ", email=" + email + 
               ", phonenumber=" + phonenumber + 
               ", password=" + password + 
               ", status=" + status + "]";
    }

    // firstname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // lastname
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Enter a valid email id");
        }
    }

    // phone number
    public long getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(long phonenumber) {
        String sphn = String.valueOf(phonenumber);
        if (sphn.length() == 10) {
            this.phonenumber = phonenumber;
        } else {
            System.out.println("Enter a valid phone number");
        }
    }

    // password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        // length >= 6 AND at least 1 uppercase
        if (password.length() >= 6 && password.matches(".*[A-Z].*")) {
            this.password = password;
        } else {
            System.out.println("Password must be at least 6 characters and contain at least one uppercase letter");
        }
    }

    // status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
