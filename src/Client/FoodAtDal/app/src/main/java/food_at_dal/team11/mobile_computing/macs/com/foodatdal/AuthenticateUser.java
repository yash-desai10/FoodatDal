package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AuthenticateUser extends AsyncTask<User, String, Boolean> {

    Boolean userAuthenticated;
    ServerDetails serverDetails;
    String urlBuilder;
    String httpMethod;


    public AuthenticateUser(){
        this.userAuthenticated = false;
        this.serverDetails = new ServerDetails();
        this.urlBuilder = serverDetails.getServerUrl() + serverDetails.getLoginUrl();
        this.httpMethod = "POST";

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(User... params) {
        User user = params[0];

        // Form the body of the POST request
        StringBuilder jsonBody = new StringBuilder();
        jsonBody.append("{\"email\" : \"");
        jsonBody.append(user.getEmailID());
        jsonBody.append("\", \"password\" : \"");
        jsonBody.append(user.getPassword());
        jsonBody.append("\"}");

        // http://guruparang.blogspot.com/2016/01/example-on-working-with-json-and.html was referenced
        // to add a JSON object as the body to the POST request
        try {
            URL url = new URL(this.urlBuilder);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(this.httpMethod);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setReadTimeout(15000);

            // set the length of the json body to be sent with the request
            if (jsonBody.toString() != null) {
                urlConnection.setRequestProperty("Content-length", jsonBody.toString().getBytes().length + "");
            }

            // Add the json body to the request
            OutputStream op = urlConnection.getOutputStream();
            op.write(jsonBody.toString().getBytes("UTF-8"));
            op.close();

            System.out.println("URL: " + url.toString());
            System.out.println("BODY: " + jsonBody.toString());

            // Make the POST HTTP request
            urlConnection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            System.out.println("RESPONSE: " + response);

            if(response.toString().equals("200 SUCCESS")){
                System.out.println("IS SUCCESS? TRUE");
                userAuthenticated = true;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userAuthenticated;
    }
}
