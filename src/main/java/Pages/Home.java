package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static Constants.HomePage.*;


public class Home extends BasePage {
    public Home(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть на кнопку Личный кабинет")
    public void accountButtonClick(){
        clickElement(accountButton);
    }

    @Step("Кликнуть на кнопку Войти в аккаунт")
    public void loginButtonMain(){
        clickElement(loginButtonMain);
    }
    @Step("Переход в аккаунт")
    public void goToConstructor()
    {
        clickElement(

                constructorButton);
    }
    @Step("Переход в ленту заказов")
    public void goToOrdersFeed()
    {
        clickElement(ordersFeedButton);
    }

    @Step("Переход по ссылке булок")
    public void clickOnBunsLink(){
        clickElement(bunsLink);
    }
    @Step("Переход по ссылке соусов")
    public void clickOnSaucesLink(){
        clickElement(saucesLink);
    }
    @Step("Переход по ссылке начинок")
    public void clickOnFillingsLink(){
        clickElement(fillingsLink);
    }

    @Step("Проверить видимость булок")
    public boolean isBunsIsDisplayed() {
        return getVisibility(buns);
    }
    @Step("Проверить видимость соусов")
    public boolean isSaucesIsDisplayed() {
        return getVisibility(sauces);
    }
    @Step("Проверить видимость начинок")
    public boolean isFillingsIsDisplayed() {
        return getVisibility(fillings);
    }
    @Step
    public boolean checkFeed(){
        return getVisibility(feederPage);
    }
    @Step("Проверить переход")
    public boolean checkConstructor(){
        return getVisibility(buns);
    }
    @Step("Кликнуть на Лого")
    public void clickLogo()
    {
        clickElement(logo);
    }


}
