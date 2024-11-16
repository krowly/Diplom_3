import Constants.URLS;
import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.SignUp;
import Pojos.PojoUser;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Сonfig {
    Account acc;
    Home home;
    Login login;
    SignUp signUp;
    int i =0;


    PojoUser pj;
    WebDriver driver;
    @Before
    public void setup(){
        try {
            driver = getWebDriver("chrome");
        } catch (MalformedURLException e) {
            System.out.println("error" + e.toString());
        }
        acc = new Account(driver);
        home = new Home(driver);
        login = new Login(driver);
        signUp = new SignUp(driver);

        driver.get(URLS.siteURL);
        i++;
        String name = "user"+ LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))+"_"+i++;
        String email = name+"@mail.com";
        String password = "password";
        pj = new PojoUser(name,email,password);
    }

    public static WebDriver getWebDriver(String browserName) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserName) {
            case "chrome":
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");


                return new ChromeDriver(chromeOptions);

            case "yandex":
                chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions.setBinary("C:/Users/user/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
            default:
                throw new RuntimeException("Неподдерживаемый браузер");
        }
    }
}
