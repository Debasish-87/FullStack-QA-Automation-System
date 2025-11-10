package api;

import io.restassured.response.Response;
import java.util.Map;

public class ReqResService {

    public Response createUser(Map<String, Object> requestBody) {
        return ApiClient.base().body(requestBody).post("/api/users");
    }

    public Response getUser(int userId) {
        return ApiClient.base().get("/api/users/" + userId);
    }

    public Response updateUser(int userId, Map<String, Object> body) {
        return ApiClient.base().body(body).put("/api/users/" + userId);
    }

    public Response deleteUser(int userId) {
        return ApiClient.base().delete("/api/users/" + userId);
    }
}
