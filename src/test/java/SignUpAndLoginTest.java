import Pojos.PojoUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignUpAndLoginTest extends BaseTest {

    @Test
    @DisplayName("Регистрация и вход через Кнопку Личный кабинет")
    public void LogInTest1() {
        signUpAndLoginAccBut();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj,actual_pj);
    }
    @Test
    @DisplayName("Регистрация и вход через Кнопку Войти в аккаунт")

    public void LogInTest2() {
        signUpAndLoginEnterAccBut();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj,actual_pj);
    }
    @Test
    @DisplayName("Регистрация и вход через Форму восстановления пароля.")

    public void LogInTest3() {
        signUpAndLogin3();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj,actual_pj);
    }
    @Test
    @DisplayName("Регистраци и вход через Форму регистрации.")
    public void LogInTest4() {
        signUpAndLogin4();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj,actual_pj);
    }
    @After
    public void tearDown() {
        //  Block of code to try
        acc.logOutButtonClick();
        driver.quit();
    }

}
