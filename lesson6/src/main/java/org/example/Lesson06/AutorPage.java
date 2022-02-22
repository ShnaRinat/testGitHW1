package org.example.Lesson06;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutorPage extends BasePage {
    public AutorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/autor15']")
    private WebElement authorButton;

    @FindBy(xpath = "//a[contains(text(),'Рейтинги')]")
    private WebElement reitingButton;

    @FindBy(xpath = "//div[contains(@onclick, 'selShow(this,10879')]")
    private WebElement bookButton;

    @FindBy(xpath = "//*[@id=\"me_7\"]")
    private WebElement markBook;

    @Step("check mark")
    public AutorPage checkBookMark(){
        return this;
    }

}