package org.example.Lesson06;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutorPage extends BasePage {
    public AutorPage(WebDriver driver) {
        super(driver);
    }

    @Step("check mark")
    public AutorPage checkBookMark(){
        return this;
    }

}