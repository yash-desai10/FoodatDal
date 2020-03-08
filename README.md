# <center>Food@Dal<center>

## Identification

|			Name        	|   Banner ID   | Email ID 				|
| --------------------------|---------------|-----------------------|
| Abishek Rajkumar      	| B00806870 	|abishek.rajkumar@dal.ca|
| Rajesh Kumar Gupta      	| B00791207     |rajesh.gupta@dal.ca 	|
| Sudarshan Suresh Srikant 	| B00808452     |sudarshan.suresh@dal.ca|
| Vismay Revankar 			| B00813441     |vismayhr@dal.ca 		|
| Yash Kamalkumar Desai 	| B00810560     |ys273139@dal.ca 		|

<br>
The code is hosted on Dalhousie's GitLab instance. You can find it [here](https://git.cs.dal.ca/revankar/mobile-computing-project). 

## Project Summary
Food@Dal is a food ordering application specific to Dalhousie University. Currently, the application is only available to Android users. The application allows users to place take-away orders for any of the eateries on campus. Users can find an eatery either by the name of the building the eatery is present in, or by the name of the eatery itself. 

The application is beneficial to the user in the following scenarios:
* When students have 2 classes that do not have much of a gap between them, it is not feasible for them to have food at one of the eateries as they will have to wait for the food to be prepared. Using the application, the students can order food 10 minutes before the first class ends and collect it at the end of the class.
* Group orders often take time due to the large number of dishes to be prepared. Instead of waiting at the eatery for the order to be served, one person can place the order on behalf of the group and collect it once prepared.
* The application provides a ubiquitous solution to ordering food on campus. The user will no longer need to use multiple applications of different eateries to order food.

Once the food has been prepared, the users will be notified via the application. They may then proceed to collect the food without having to wait for their order.

## Design Documents
The design documents such as wireframes, clickstreams, prototypes and test plans can be found [here](https://git.cs.dal.ca/revankar/mobile-computing-project/tree/develop/documentation/Update1)

## Libraries
This section provides a list of all the libraries used for the development of the application.

**android.view:** Android's view class is used to create and manipulate basic build blocks of the user interface of the application. The documentation can be found [here](https://developer.android.com/reference/android/view/View).

**android.os:** The android.os package was used for multi-threading in the application with the use of AsyncTask. The documentation can be found [here](https://developer.android.com/reference/android/os/package-summary).

**android.support:** This library is used to make the application compatible with earlier versions of Android. The documentation can be found [here](https://developer.android.com/topic/libraries/support-library/).

**android.widget:** This library is used to manipulate different views such as LinearLayout, ImageView, etc. The documentation can be found [here](https://developer.android.com/guide/topics/appwidgets/overview).

Standard java libraries such as java.util, java.io and java.net were used to implement the logic of the application.


## Installation Notes
**Step 1:** Install Android Studio and Android SDK from [here](https://developer.android.com/studio/install).

**Step 2:** The minimum required Android SDK version for running this application on an Android emulator or smartphone is v23.0.

**Step 3:** The following dependencies are required for running the application:

    implementation fileTree(dir: 'libs', include: ('*.jar'))
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:support-v4:28.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'


**Step 4:** To run the application, select "Run" option in Android Studio and choose one of the mobile phone options available for running it on an emulator or the connected phone for running it on a physical device.<br/>

The project involves setting up a server built on Python Django. A virtual environment with the latest django version installed is required to replicate the server. The server code is available on the GitLab environment under Server folder. To run the server, type the following in cmd: ```python manage.py runserver 0.0.0.0:8000```


## Code Examples

**Problem 1: We needed a method to validate user input before making the REST API call to avoid loading the server with malformed requests**

During the user login step, to avoid creating unecessary REST API calls to the server which contain syntactically wrong email IDs or blank passwords, we implemented a validation step. Only once the user input was validated, was a REST API call made to the server. This was done to avoid loading the server with malformed requests that were not going to let the user login anyway.
```
public boolean validateUserInput() {
    boolean validInput = false;
    boolean validEmail = false;
    boolean validPassword = false;
    String inputEmail = edt_email.getText().toString();
    String inputPassword = edt_password.getText().toString();

    // Validate the syntax of the email string inputted by the user
    if (inputEmail.length() > 0) {    
        Pattern pattern = Pattern.compile(emailRegexPattern);
        Matcher matcher = pattern.matcher(inputEmail);
        // true if the email is valid (i.e., it matches the regex pattern)
        validEmail = matcher.find();        
    }

    // Validate the syntax of the password string inputted by the user
    if (inputPassword.length() > 0) { 
        validPassword = true;
    }

    if (validEmail == true && validPassword == true) {
        validInput = true;
    }
    System.out.println("EMAIL: " + String.valueOf(validEmail) + 
    " PW: " + String.valueOf(validPassword));
    System.out.println("INPUT: " + String.valueOf(validInput));
    return validInput;
}
```


**Problem 2: Validating a valid email ID**
There are numerous conditions to check for when validating an email ID. We handled all these conditions using regular expressions and java's Pattern and Matcher classes. The regex expression we used to validate email IDs is given below.
```
String emailRegexPattern = "^([a-zA-Z0-9]([-.\\w]*[a-zA-Z0-9])*@(([a-zA-Z0-9])+([-\\w]*[a-zA-Z0-9])*\\.)+[a-zA-Z]{2,9})$";
```

**Problem 3: Validating the password during new user registration**
To comply with the norm, we ensure that the passwords follow certain rules, i.e., they must contain atleast one lowercase alphabet, one uppercase alphabet, a digit and a special character. However, validating a password using regex would not be feasible as the order in which the characters occur is not defined. Hence, we had to do it programmatically by iterating through the entire password, one character at a time. The method we implemented to check the validity of passwords is given below.
```
public boolean validatePassword(String password) {
    boolean passwordValid = false;
    boolean containsUpperCaseChar = false;
    boolean containsLowerCaseChar = false;
    boolean containsSpecialChar = false;
    boolean containsNumber = false;

	// Check for presence of special character in the password
    Pattern checkSpecialCharacter = Pattern.compile("[^a-zA-Z0-9]"); 
    Matcher passwordMatcher = checkSpecialCharacter.matcher(password);
    containsSpecialChar = passwordMatcher.find();

    for (int i = 0; i < password.length(); i++) {
        Character c = password.charAt(i);
        if (Character.isDigit(c)) containsNumber = true;
        else if (Character.isLowerCase(c)) containsLowerCaseChar = true;
        else if (Character.isUpperCase(c)) containsUpperCaseChar = true;
    }

    if (containsLowerCaseChar == true && containsUpperCaseChar == true && 
    	containsNumber == true && containsSpecialChar == true) {
        passwordValid = true;
    }
    return passwordValid;
}
```

## Feature Section
This section describes the various features of the Food@Dal application.
* **User login and registration:** We have implemented a server using Django. Users can register with us to create their accounts and login to the application to order food.
* **Reset password:** An automated email will be sent to the user with an auto-generated password.
* **Filter eateries by name and building:** This feature allows users to search for eateries in the Dalhousie campus either by their names or by the building in which the eatery is located in.
* **Select multiple food items and place order:** Users can select multiple items from the menu of a single eatery and place an order. The order request is sent as a REST API call.
* **Customize order:** Users can customize their orders by changing the toppings on the pizza, contents of their burger, etc.
* **View cart:** During the operation of the application, users can always check the contents of the cart.
* **Check status of order:** Users are updated when their food order is prepared. This way, they do not need to wait at the eatery without any information on their order.

## Final Project Status
Write a description of the final status of the project. Did you achieve all your goals? What would be the next step for this project (if it were to continue)?

### Minimum Functionality:

* A basic, working implementation of a client-side application. (Completed)
* The client-side application should be able to send an order request to the server which will be processed and the order ready response will be sent back to the application. (Completed)
* The client-side application should support more than one restaurant’s menu. Additionally, it should successfully send the order to the correct seller. (Completed)

### Expected Functionality:

* Provision of registration for new users and login for existing users. (Completed)
* Implementation of CRUD operations on User model. (Completed)
* Provision to change and reset password for user accounts based on CRUD operations. (Completed)
* Search food outlets by name or building inside the application. (Completed)
* Store and display menus for each outlet. (Completed)
* Ability to customize and place order on the checkout screen. (Completed)
* Simulated notification to user after an arbitrary delay on the order being ready. (Completed)
* Implementation of an order history screen with previous and active orders. (Completed)
* Ability to check details of current order on order history section. (Completed)

### Bonus Functionality:

* Integration of a payment gateway. (Not completed)
* Send advertisement push-notifications to customers. (Not completed)
* Pre-order items for a designated period of time. (Not completed)
* Locate nearest eatery in the campus using GPS and Google Maps API. (Not completed)
* Ratings of food/beverages. (Not completed)
* Add a tracking feature through which people can monitor their expenditure on food on a weekly or monthly basis. (Not completed)

## Sources
### Images

* [Burger](https://icons8.com/icon/12869/burger)
* [Pizza](https://icons8.com/icon/12867/pizza)
* [Fries](https://icons8.com/icon/12875/french-fries)
* [Hotdog](https://icons8.com/icon/82476/frankfurter)
* [Drink](https://icons8.com/icon/81979/drink)
* [Cookies](https://icons8.com/icon/12878/cookies)
* [Subway](https://halifaxshoppingcentre.com/stores/halifaxcentre-subway)
* [Tim Hortons](https://locations.timhortons.com/ca/ns/halifax/1781-upper-water-st.html)
* [Second Cup](https://halifaxshoppingcentre.com/stores/halifaxcentre-second-cup)
* [Global Village](https://www.yelp.ca/biz_photos/curry-village-indian-restaurant-halifax?select=ADIekuAcl-nFL3oGk9AsXQ)
* [Killam Bistro](https://www.facebook.com/pages/Killam-Bistro/518508778193787)
* [Mezza](http://www.mezzalebanesekitchen.com/canada/)
* [Pizza Pizza](https://www.newswire.ca/news-releases/pizza-pizza-brings-cauliflower-based-pizza-crust-to-menu-689094181.html)
* [Grawood](https://www.facebook.com/Grawood/)
* [Killam Library](https://www.yelp.ca/biz_photos/killam-memorial-library-halifax?select=1jucUPhybWld-teIk5FGew)
* [DSU](https://www.dal.ca/campus-maps/building-directory/studley-campus/sub.html)
* [Tupper Building](https://www.news957.com/local/2015/11/17/dalhousie-medical-school-closed-after-biohazardous-material-found/)
* [Mona Campbell](https://www.canadianconsultingengineer.com/features/mona-campbell-building/)
* [Goldberg](https://csgs.cs.dal.ca/events/dcsi/)
* [LSC Common Area](https://www.dal.ca/dept/facilities/campus-development/projects/life-sciences-centre-retrofit-project.html)
* [Dalplex](https://www.dal.ca/campus-maps/building-directory/studley-campus/dalplex.html)
* [Sexton House](https://www.dal.ca/campus-maps/building-directory/sexton-campus/sexton-house.html)

### Design guides

* [Nielsen’s heuristics](https://www.nngroup.com/articles/ten-usability-heuristics/)
* [Usage-centered design](https://en.wikipedia.org/wiki/Principles_of_user_-interface_design)

