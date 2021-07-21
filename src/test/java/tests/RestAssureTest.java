package tests;

import io.restassured.http.ContentType;
import io.restassured.*;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RestAssureTest {

    static String url;

    @BeforeMethod
    public void innit() {
        url = "http://demo.guru99.com/V4/sinkministatement.php";
    }

    @Test(dependsOnMethods = {"getResponseStatus"})
    public static void getResponseBody() {

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get(url).then().log()
                .body();
    }

    @Test
    public static void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get(url).getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

    @Test
    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                given().when().get(url).then().extract().headers());
    }


}
