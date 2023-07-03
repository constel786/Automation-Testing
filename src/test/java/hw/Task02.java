package hw;

import base_urls.ReqResBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task02 extends ReqResBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void Task02(){
        spec.pathParam("first", "users");

        String expectedData = "{\"name\": \"morpheus\",\"job\": \"leader\",\"id\": \"496\",\"createdAt\": \"2022-10-04T15:18:56.372Z\"}";
        Response response = given(spec).contentType(ContentType.JSON).body(expectedData).post("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals("morpheus", jsonPath.getString("name"));
        assertEquals("leader", jsonPath.getString("job"));
        assertEquals(496, jsonPath.getInt("id"));
    }
}
