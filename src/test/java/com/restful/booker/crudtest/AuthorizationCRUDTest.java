package com.restful.booker.crudtest;

import com.restful.booker.booker.model.AuthorizationPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationCRUDTest {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/auth";
    }

    @Test
    public void createToken() {

        AuthorizationPojo authorizationPojo = new AuthorizationPojo();
        authorizationPojo.setUserName("admin");
        authorizationPojo.setPassword("password123");

        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .when()
                        .body(authorizationPojo)
                        .post();
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
