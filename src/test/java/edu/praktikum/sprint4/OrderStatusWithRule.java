package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.rules.BrowserRule;
import org.junit.Rule;
import org.junit.Test;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static org.junit.Assert.assertTrue;

public class OrderStatusWithRule {

    private static final String NOT_EXISTING_ORDER_NUMBER = randomString();

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.open()
                .clickCheckOrder()
                .inputOrderNumberInField(NOT_EXISTING_ORDER_NUMBER)
                .clickGo();

        assertTrue("Сообщение об ошибке не показывается",
                mainPage.getNotFound().checkMessageExist());
    }
}
