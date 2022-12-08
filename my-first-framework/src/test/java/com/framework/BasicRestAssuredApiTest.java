package com.framework;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class BasicRestAssuredApiTest {

    @Test
    public void getStatusCodeIs200() {
        RestAssured.get("https://api.github.com/")
                .then()
                .statusCode(200);
    }





    @Test
    public void headersContainCorrectValues() {
        RestAssured.get("https://api.github.com/")
                .then()
                .assertThat()
                .header("content-type", "application/json; charset=utf8")
                .header("X-Ratelimit-Limit", "60");
    }





    @Test
    public void bodyContainCorrectValues() {
        RestAssured.get("https://api.github.com/users/joejingojack")
                .then()
                .assertThat()
                .body("login", equalTo("joejingojack"))
                .body("type", equalTo("User"));
    }
}
