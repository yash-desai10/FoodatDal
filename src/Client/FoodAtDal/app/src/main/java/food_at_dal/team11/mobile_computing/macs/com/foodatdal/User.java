package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

public class User extends Object {
    protected String emailID;
    protected String password;

    public User(){}

    public User(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
