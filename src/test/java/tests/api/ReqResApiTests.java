package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqResApiTests {

    @Test
    public void getUsersTest() {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(res.asString().contains("Janet"));
    }

    @Test
    public void createUserTest() {
        String body = "{ \"name\": \"john\", \"job\": \"tester\" }";

        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("https://reqres.in/api/users");

        Assert.assertEquals(res.getStatusCode(), 201);
        Assert.assertTrue(res.asString().contains("john"));
    }

    @Test
    public void updateUserTest() {
        String body = "{ \"name\": \"john\", \"job\": \"lead tester\" }";

        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .put("https://reqres.in/api/users/2");

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(res.asString().contains("lead tester"));
    }

    @Test
    public void deleteUserTest() {
        Response res = RestAssured.delete("https://reqres.in/api/users/2");
        Assert.assertEquals(res.getStatusCode(), 204);
    }
}
