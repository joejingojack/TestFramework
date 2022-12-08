package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MyFirstTestRefactored {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll // @BeforeMethod in TestNG
    static void setup() {
        // Create the driver object
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roone\\Desktop\\dev\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        String user = "joejingojack";
        driver.get(BASE_URL + user);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);
    }


    @Test
    void repoLinkGoesToCorrectRepo() {

        String user = "joejingojack";
        driver.get(BASE_URL + user);

        //Act
        String repo = "stunning-guacamole";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String actualUrl = driver.getCurrentUrl();

        //Assert
        assertEquals(BASE_URL + "joejingojack/" + repo, actualUrl);
    }

    @Test
    void repositoryCountIsCorrect() {

        //Act
        driver.get(BASE_URL + "joejingojack/" + "?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("(//a[contains(@class,'UnderlineNav-item js-responsive-underlinenav-item')])[2]"));

        //Assert
        assertEquals(9, repos.size());
    }
}
