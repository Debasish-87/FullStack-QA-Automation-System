package tests.api;

import api.ReqResService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.Map;

public class ReqResTests {

    ReqResService service = new ReqResService();

    @Test(description = "Create User API Test")
    public void createUserTest() {
        Map<String, Object> requestBody = JsonUtils.readJson("src/test/resources/testdata/createUser.json");

        Response res = service.createUser(requestBody);

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertTrue(res.jsonPath().getString("id").length() > 0);
        Assert.assertEquals(res.jsonPath().getString("name"), requestBody.get("name"));
    }

    @Test(description = "Get User API Test")
    public void getUserTest() {
        Response res = service.getUser(2);
        Assert.assertEquals(res.statusCode(), 200);
    }
}
