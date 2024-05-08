package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageForSteps {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderNumberInput = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    private NotFound notFound;

    public MainPageForSteps(WebDriver webDriver) {
        notFound = new NotFound(webDriver);
    }

    public By getCheckOrderButton() {
        return checkOrderButton;
    }

    public By getOrderNumberInput() {
        return orderNumberInput;
    }

    public By getGoButton() {
        return goButton;
    }

    public NotFound getNotFound() {
        return notFound;
    }
}
