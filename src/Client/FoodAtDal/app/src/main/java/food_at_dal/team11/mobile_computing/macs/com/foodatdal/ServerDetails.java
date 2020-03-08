package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

public class ServerDetails extends Object {
    private static String serverUrl = "http://192.168.2.33:8000/";
    private static String adminPanelUrl = "admin/";
    private static String loginUrl = "login/";
    private static String registerNewUserUrl = "register/";
    private static String isUserLoggedInUrl = "getUser/";
    private static String placeOrderUrl = "placeorder/";

    public ServerDetails() {

    }

    public static String getServerUrl() {
        return serverUrl;
    }

    public static String getAdminPanelUrl() {
        return adminPanelUrl;
    }

    public static String getLoginUrl() {
        return loginUrl;
    }

    public static String getRegisterNewUserUrl() {
        return registerNewUserUrl;
    }

    public static String getIsUserLoggedInUrl() {
        return isUserLoggedInUrl;
    }

    public static String getPlaceOrderUrl() {
        return placeOrderUrl;
    }
}
