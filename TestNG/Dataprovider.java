import org.testng.annotations.DataProvider;

public class Dataprovider {
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin1", "k" , "admink@gmail.com", "8798767897"},
                { "admin2", "m" , "adminm@gmail.com", "8798367897"},
                { "admin3", "p" , "adminp@gmail.com", "8798167897"},
        };
    }
}
