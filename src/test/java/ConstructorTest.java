import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Тест на переход к разделу Конструктор")
    public void GoToOrderFeed() {
        signUpAndLoginAccBut();
        home.goToConstructor();
        assertTrue(home.checkConstructor());
    }
    @Test
    @DisplayName("Тест на переход к разделу Лента Заказов")
    public void goToConstructorTest() {
        signUpAndLoginAccBut();
        home.goToOrdersFeed();
        assertTrue(home.checkFeed());
    }
}
