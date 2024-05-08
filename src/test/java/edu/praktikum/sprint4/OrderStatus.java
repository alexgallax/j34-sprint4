package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.MainPageForSteps;
import edu.praktikum.sprint4.steps.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class OrderStatus {

    private static final String NOT_EXISTING_ORDER_NUMBER = randomString();

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open()
                .clickCheckOrder()
                .inputOrderNumberInField(NOT_EXISTING_ORDER_NUMBER)
                .clickGo();

        assertTrue("Сообщение об ошибке не показывается",
                mainPage.getNotFound().checkMessageExist());
    }

    @Test
    public void notFoundIfOrderNotExistsSteps() {
        MainPageForSteps mainPage = new MainPageForSteps(webDriver);
        Steps steps = new Steps(webDriver);

        steps.open(MainPageForSteps.URL)
                .click(mainPage.getCheckOrderButton())
                .input(mainPage.getOrderNumberInput(), NOT_EXISTING_ORDER_NUMBER)
                .click(mainPage.getGoButton());

        assertTrue("Сообщение об ошибке не показывается",
                mainPage.getNotFound().checkMessageExist());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
