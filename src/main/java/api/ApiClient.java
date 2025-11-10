package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    public static RequestSpecification base() {
        return RestAssured.given()
                .baseUri("https://reqres.in")
                .contentType("application/json")
                .log().all();
    }
}
