package org.example.Lesson06;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Story("Work this a book")
public class FantlabPageObjectTest {
    WebDriver driver;
    private final static String FANTLAB_URL = "https://fantlab.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(FANTLAB_URL);
    }

    @Test
    void likeBook(){
        new MainPage(driver)
                .fillLogin("test_test")
                .fillPassword("Test123456")
                .clickLoginButton();

    }

    @AfterEach
    void killDriver(){
        driver.quit();
    }

}