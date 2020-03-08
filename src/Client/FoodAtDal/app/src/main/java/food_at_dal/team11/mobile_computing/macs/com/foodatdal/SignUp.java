package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    EditText edt_first_name, edt_last_name, edt_password, edt_re_enter_password, edt_email, edt_banner, edt_dob, edt_last_order;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        configureUIComponents();
        setOnClickListeners();
    }

    public void configureUIComponents() {
        edt_first_name = (EditText) findViewById(R.id.edt_register_first_name);
        edt_last_name = (EditText) findViewById(R.id.edt_register_last_name);
        edt_email = (EditText) findViewById(R.id.edt_register_email);
        edt_banner = (EditText) findViewById(R.id.edt_register_banner);
        edt_dob = (EditText) findViewById(R.id.edt_register_dob);
        btn_register = (Button) findViewById(R.id.btn_register);
        edt_password = (EditText) findViewById(R.id.edt_register_password);
        edt_re_enter_password = (EditText) findViewById(R.id.edt_register_reenter_password);
    }

    public void setOnClickListeners() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean userInputValid = validateUserInput();
                if (userInputValid == true) {
                    Boolean userCreated = createUser();
                    if (userCreated.booleanValue() == true) {
                        Toast.makeText(getApplicationContext(),"New user created! Please login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error while creating new user", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Input data is not valid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean validateUserInput() {
        String firstNameRaw = edt_first_name.getText().toString();
        String firstName = firstNameRaw.replaceAll("\\s+_", " "); // Replace multiple spaces with a single space
        String lastNameRaw = edt_last_name.getText().toString();
        String lastName = lastNameRaw.replaceAll("\\s+", " ");
        String emailID = edt_email.getText().toString();
        String bannerIDRaw = edt_banner.getText().toString();
        // Convert first charecter in Banner ID to upper case
        String bannerID = bannerIDRaw.substring(0, 1).toUpperCase() + bannerIDRaw.substring(1);
        String password = edt_password.getText().toString();
        String reEnterPassword = edt_re_enter_password.getText().toString();

        boolean userInputValid = false;
        boolean fnameValid = false;
        boolean lnameValid = false;
        boolean emailValid = false;
        boolean bannerIDValid = false;
        boolean passwordValid = false;
        boolean passwordMatch = true;

        // Validate first name
        Pattern namePattern = Pattern.compile("[^a-zA-Z\\s-]"); // Name can only contain alphabets, spaces and -
        Matcher firstNameMatcher = namePattern.matcher(firstName);
        fnameValid = !(firstNameMatcher.find());

        Matcher lastNameMatcher = namePattern.matcher(lastName);
        lnameValid = !(lastNameMatcher.find());

        Pattern emailPattern = Pattern.compile("^([a-zA-Z0-9]([-.\\w]*[a-zA-Z0-9])*@(([a-zA-Z0-9])+([-\\w]*[a-zA-Z0-9])*\\.)+[a-zA-Z]{2,9})$");
        Matcher emailMatcher = emailPattern.matcher(emailID);
        emailValid = emailMatcher.find();

        Pattern bannerIdPattern = Pattern.compile("^[A-Z][0-9]{8}$"); //Banner format: Bxxxxxxxx (x represents a digit)
        Matcher bannerIdMatcher = bannerIdPattern.matcher(bannerID);
        bannerIDValid = bannerIdMatcher.find();

        if (!password.equals(reEnterPassword)) {
            Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
            passwordMatch = false;
        }

        passwordValid = validatePassword(password);

        if (fnameValid == true && lnameValid == true && emailValid == true && bannerIDValid == true && passwordValid == true && passwordMatch == true) {
            userInputValid = true;
        }

        return userInputValid;
    }

    public boolean validatePassword(String password) {
        boolean passwordValid = false;
        boolean containsUpperCaseChar = false;
        boolean containsLowerCaseChar = false;
        boolean containsSpecialChar = false;
        boolean containsNumber = false;

        Pattern checkSpecialCharacter = Pattern.compile("[^a-zA-Z0-9]"); // Check for presence of special character in the password
        Matcher passwordMatcher = checkSpecialCharacter.matcher(password);
        containsSpecialChar = passwordMatcher.find();

        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isDigit(c)) containsNumber = true;
            else if (Character.isLowerCase(c)) containsLowerCaseChar = true;
            else if (Character.isUpperCase(c)) containsUpperCaseChar = true;
        }

        if (containsLowerCaseChar == true && containsUpperCaseChar == true && containsNumber == true && containsSpecialChar == true) {
            passwordValid = true;
        }
        return passwordValid;
    }

    public Boolean createUser() {
        Boolean userCreated = false;
        String firstNameRaw = edt_first_name.getText().toString();
        String firstName = firstNameRaw.replaceAll("\\s+_", " "); // Replace multiple spaces with a single space
        String lastNameRaw = edt_last_name.getText().toString();
        String lastName = lastNameRaw.replaceAll("\\s+", " ");
        String emailID = edt_email.getText().toString();
        String bannerIDRaw = edt_banner.getText().toString();
        // Convert first character in Banner ID to upper case
        String bannerID = bannerIDRaw.substring(0, 1).toUpperCase() + bannerIDRaw.substring(1);
        String password = edt_password.getText().toString();

        // Date needs to be implemented after https://git.cs.dal.ca/revankar/mobile-computing-project/issues/1 is fixed
        Date dateOfBirth = null;

        UserDetails userDetails = new UserDetails(firstName, lastName, emailID, bannerID, dateOfBirth, password);
        CreateNewUser userCreation = new CreateNewUser();
        try {
            userCreated = userCreation.execute(userDetails).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userCreated;
    }
}