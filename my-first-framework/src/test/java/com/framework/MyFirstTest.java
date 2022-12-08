package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {

    @Test
    void usernameIsCorrectOnOvierviewTab() {

        //Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roone\\Desktop\\dev\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "joejingojack";
        driver.get("https://github.com/" + user);

        //Act
        String actualUsername = driver.findElement(By.className("p-nickname")).getText();

        //Assert
        Assertions.assertEquals(user, actualUsername);

        driver.close();
    }
}
