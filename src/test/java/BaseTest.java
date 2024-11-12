import Constants.URLS;
import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.SignUp;
import Pojos.PojoUser;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    static Account acc;
    static Home home;
    static Login login;
    static SignUp signUp;
    static int i =0;


    static PojoUser pj;
    static WebDriver driver;
    @Before
    public void setup()
     {
         driver = getWebDriver("chrome");

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

    public static WebDriver getWebDriver(String browserName) {
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserName) {
            case "chrome":
                chromeOptions.addArguments("--no-sandbox");
                return new ChromeDriver(chromeOptions);
            case "yandex":
                chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions.setBinary("C:/Users/user/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
            default:
                throw new RuntimeException("Неподдерживаемый браузер");
        }
    }

    void sign()
    {
        signUp.signUpLinkClick();
        signUp.sendSignUpData(pj );
        signUp.clickSignUpButton();
    }
    void log()
    {
        login.sendLogInData(pj);
        login.clickLogInButton();
    }


    @Step("Регистрация и вход через кнопку Личный кабинет")
    public void signUpAndLoginAccBut()
    {
        home.accountButtonClick();
        sign();
        driver.get(URLS.loginURL);
        log();
        home.accountButtonClick();
    }
    @Step("Регистрация и вход через кнопку Войти в аккаунт")
    public void signUpAndLoginEnterAccBut(){
        home.loginButtonMain();
        sign();
        driver.get(URLS.loginURL);
        log();
        home.accountButtonClick();
    }
    @Step("Регистрация и вход через форму восстановления пароля.")
    public void signUpAndLogin3(){
        home.accountButtonClick();
        sign();
        login.clickOnForgotPasswordLink();
        login.clickOnLoginLink();
        log();
        home.accountButtonClick();
    }
    @Step("Регистрация и вход через форму регистрацию")
    public void signUpAndLogin4(){
        home.accountButtonClick();
        sign();
        login.clickOnRegisterLink();
        login.clickOnLoginLink();
        log();
        home.accountButtonClick();
    }

    @After
    public void tearDown() {
            //  Block of code to try
        home.accountButtonClick();
        acc.logOutButtonClick();

        driver.quit();
    }
}
