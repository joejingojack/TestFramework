package com.framework.uitests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTabTests extends BaseTestClass {

    @Test
    void repositoryCountIsCorrect() {

        //Act
        driver.get(BASE_URL + "joejingojack/" + "?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("(//a[contains(@class,'UnderlineNav-item js-responsive-underlinenav-item')])[2]"));

        //Assert
        assertEquals(9, repos.size());
    }
}
