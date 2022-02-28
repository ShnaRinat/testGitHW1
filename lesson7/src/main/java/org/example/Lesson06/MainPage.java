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

    @Step("Send login go login")
    public MainPage fillLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }
    @Step("Send password to password")
    public MainPage fillPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("click on button Enter")
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

    @FindBy(xpath = "//a[@href='/autor15']")
    private WebElement authorButton;

    @FindBy(xpath = "//a[contains(text(),'Рейтинги')]")
    private WebElement reitingButton;

    @FindBy(xpath = "//div[contains(@onclick, 'selShow(this,10879')]")
    private WebElement bookButton;

    @FindBy(xpath = "//*[@id=\"me_7\"]")
    private WebElement markBook;

    @Step("Move to top")
    public MainPage clickOnTop(){
        reitingButton.click();
        return this;
    }

    @Step("Move to Autor")
    public MainPage clickOnAutor(){
        authorButton.click();
        return this;
    }
    @Step("Move to Book")
    public MainPage clickOnBook(){
        bookButton.click();
        return this;
    }
    @Step("Mark Book")
    public MainPage clickOnMark(){
        markBook.click();
        return this;
    }

}