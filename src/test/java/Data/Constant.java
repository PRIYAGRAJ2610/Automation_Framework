package Data;

public  class Constant {

    public class LoginConstant {
        public static final String STANDARD_USERNAME = "standard_user";
        public static final String STANDARD_PASSWORD = "secret_sauce";
        public static final String SauceLabsBikeLight = "Sauce Labs Bike Light";

        public static final String Problem_Username = "problem_user";

    }

    public class InvalidUser
    {
        public static final String userName = "invalid_USer" ;
        public static final String password = "invalid_password";
    }

    public enum Timeout {
        SHORT(5),
        MEDIUM(10),
        LONG(30),
        EXTRA_LONG(60);

        private final int seconds;

        Timeout(int seconds) {
            this.seconds = seconds;
        }

        public int getSeconds() {
            return seconds;
        }
    }
}
