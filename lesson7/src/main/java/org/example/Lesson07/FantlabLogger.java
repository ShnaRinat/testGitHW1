package org.example.Lesson07;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class FantlabLogger implements WebDriverListener {
    public void beforeClick(WebElement element){
        Allure.step("try to click on .." + element.getText());
    }

    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Screen Shot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}