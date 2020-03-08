package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText edt_email, edt_password;
    Button btn_login, btn_new_user;
    TextView tv_forgot;
    // The below regex for a valid email ID was constructed using resources from http://regexlib.com/
    String emailRegexPattern = "^([a-zA-Z0-9]([-.\\w]*[a-zA-Z0-9])*@(([a-zA-Z0-9])+([-\\w]*[a-zA-Z0-9])*\\.)+[a-zA-Z]{2,9})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configureUIComponents();
        setOnClickListeners();
    }

    protected void configureUIComponents() {
        edt_email = (EditText) findViewById(R.id.edt_login_email);
        edt_password = (EditText) findViewById(R.id.edt_login_password);
        tv_forgot = (TextView) findViewById(R.id.tv_forgot);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_new_user = (Button) findViewById(R.id.btn_new_user);
        tv_forgot = (TextView) findViewById(R.id.tv_forgot);
    }

    protected void setOnClickListeners() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        /*btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // OnClick listener for the login button
                boolean userInputValid = validateUserInput();
                if (edt_email.getText().length() == 0 || edt_password.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Email ID or password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (userInputValid) {
                    boolean credentialsValid = false;
                    credentialsValid = authenticateUser();
                    if (credentialsValid == true) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid character(s) present in emailID or password", Toast.LENGTH_LONG).show();
                }
            }
        });*/

        btn_new_user.setOnClickListener(new View.OnClickListener() {    // OnClick listener for new user button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    public boolean validateUserInput() {
        boolean validInput = false;
        boolean validEmail = false;
        boolean validPassword = false;
        String inputEmail = edt_email.getText().toString();
        String inputPassword = edt_password.getText().toString();

        if (inputEmail.length() > 0) {    // Validate the syntax of the email string inputted by the user
            Pattern pattern = Pattern.compile(emailRegexPattern);
            Matcher matcher = pattern.matcher(inputEmail);
            validEmail = matcher.find();        // true if the email is valid (i.e., it matches the regex pattern)
        }

        if (inputPassword.length() > 0) { // Validate the syntax of the password string inputted by the user
            validPassword = true;
        }

        if (validEmail == true && validPassword == true) {
            validInput = true;
        }
        System.out.println("EMAIL: " + String.valueOf(validEmail) + " PW: " + String.valueOf(validPassword));
        System.out.println("INPUT: " + String.valueOf(validInput));
        return validInput;
    }

    public boolean authenticateUser() {
        String email = edt_email.getText().toString();
        String pw = edt_password.getText().toString();
        User user = new User(email, pw);
        AuthenticateUser authenticateUser = new AuthenticateUser();
        Boolean userAuthenticated = false;
        try {
            userAuthenticated = authenticateUser.execute(user).get();
            System.out.println("LGA userAuthenticated? " + String.valueOf(userAuthenticated));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userAuthenticated;
    }
}
