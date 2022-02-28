package org.example.Lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FantlabTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String FANTLAB_URL = "https://fantlab.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(FANTLAB_URL);

    }

    @Test
    void loginViaCookiesTest() throws InterruptedException {
        Cookie cookie = new Cookie("fl_s", "b110d61b979856d4");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        //Assert.assertThat("Moй логин", CoreMatchers.containsString(String.valueOf(By.xpath("//*[contains(text(),'Мой логин')]"))));
        Assert.assertThat(String.valueOf(By.xpath("//*[contains(text(),'Мой логин')]")), CoreMatchers.containsString("Мой логин"));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}