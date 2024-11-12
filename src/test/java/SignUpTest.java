import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {


    @Test
    @DisplayName("Тест Попытка регистрации с невалидным паролем")
    public void WrongPassTest() {
        home.accountButtonClick();
        signUp.signUpLinkClick();
        pj.setPassword("passw");
        signUp.sendSignUpData(pj );
        signUp.clickSignUpButton();
        String s = signUp.getErrorPasswordMessage();
        assertEquals("Некорректный пароль", s);
        driver.quit();
    }
    @After
    @Override
    public void tearDown() {
    }

}
