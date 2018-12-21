import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;

public class Hello {
    public static void main(String[] args) {
        try {
            for (int i=0; i < 10; ++i) {
                System.out.println(new Date());
                key1();
                key2();
                Thread.sleep(TimeUnit.MINUTES.toMillis(1));
                System.out.println("----------");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void key1() {
        GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder googleAuthenticatorConfigBuilder =
                new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder();
        googleAuthenticatorConfigBuilder.setTimeStepSizeInMillis(TimeUnit.MINUTES.toMillis(30));
        GoogleAuthenticatorConfig googleAuthenticatorConfig = googleAuthenticatorConfigBuilder.build();

        GoogleAuthenticator gAuth = new GoogleAuthenticator(googleAuthenticatorConfig);
//        final GoogleAuthenticatorKey key = gAuth.createCredentials();

        String y = "BPSLJXQJX7LINLHW";
        int code = gAuth.getTotpPassword(y);

        System.out.println("5 mins");
        System.out.println(code);
    }

    private static void key2() {
        GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder googleAuthenticatorConfigBuilder =
                new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder();
        googleAuthenticatorConfigBuilder.setTimeStepSizeInMillis(TimeUnit.MINUTES.toMillis(1));
        GoogleAuthenticatorConfig googleAuthenticatorConfig = googleAuthenticatorConfigBuilder.build();

        GoogleAuthenticator gAuth = new GoogleAuthenticator(googleAuthenticatorConfig);

        String y = "PYJ7NAO5J7HVK5DS";
        int code = gAuth.getTotpPassword(y);

        System.out.println("1 min");
        System.out.println(code);
    }
}
