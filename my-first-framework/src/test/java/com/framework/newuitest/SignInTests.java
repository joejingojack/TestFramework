package com.framework.newuitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.framework.newuitest.StringUtils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInTests extends BaseTestClass {

    @Test
    void invalidLoginFailsToSignIn() {

        driver.get(BASE_URL + "login");

        // enter credentials and click "Sign In"
        driver.findElement(By.id("login_field")).sendKeys("somelogin");
        driver.findElement(By.id("password")).sendKeys(generateRandomString(5)); // HAS-A relationship
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        boolean isErrorDisplayed = driver.findElement(By.className("flash-error")).isDisplayed();

        assertTrue(isErrorDisplayed);
    }



}
