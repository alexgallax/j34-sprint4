package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver webDriver;

    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderNumberInput = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    private NotFound notFound;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        notFound = new NotFound(webDriver);
    }

    public MainPage open() {
        webDriver.get(URL);
        return this;
    }

    public MainPage clickCheckOrder() {
        webDriver.findElement(checkOrderButton).click();
        return this;
    }

    public MainPage inputOrderNumberInField(String text) {
        webDriver.findElement(orderNumberInput).sendKeys(text);
        return this;
    }

    public MainPage clickGo() {
        webDriver.findElement(goButton).click();
        return this;
    }

    public NotFound getNotFound() {
        return notFound;
    }
}
