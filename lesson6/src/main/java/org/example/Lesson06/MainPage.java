package org.example.Lesson06;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='логин']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs']")
    private WebElement loginButton;

    @Step("Login plays")
    public MainPage fillLogin(Spring login){
        loginInput.sendKeys(login);
        return this;
    }
    @Step("password plays")
    public MainPage fillPassword(Spring password){
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("click on button")
    public MainPage clickLoginButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }

}