package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import java.util.Date;

public class UserDetails extends User {
    private String firstName;
    private String lastName;
    private String bannerID;
    private Date dateOfBirth;

    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, String emailID, String bannerID, Date dateOfBirth, String password) {
        super(emailID, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.bannerID = bannerID;
        this.dateOfBirth = dateOfBirth;
    }

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

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
