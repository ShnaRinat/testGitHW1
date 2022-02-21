package org.example.Lesson03;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FantlabTestLike {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fantlab.ru/");
        driver.findElement(By.xpath("//input[@placeholder='логин']")).sendKeys("test_test");
        driver.findElement(By.xpath("//input[@placeholder='пароль']")).sendKeys("Test123456");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Рейтинги')]")).click();
        driver.findElement(By.xpath("//a[@href='/autor15']")).click();
        driver.findElement(By.xpath("//div[contains(@onclick, 'selShow(this,10879')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"me_7\"]")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}