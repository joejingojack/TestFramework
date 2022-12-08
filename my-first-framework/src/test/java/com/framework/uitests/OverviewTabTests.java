package com.framework.uitests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabTests extends BaseTestClass {

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
}
