package patch_requests;

import Utils.ObjectMapperUtils;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static Utils.ObjectMapperUtils.*;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static test_data.JsonPlaceHolderTestData.expectedDataMap;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
     Given
         1) https://jsonplaceholder.typicode.com/todos/198
         2) {
              "title": "Read the books"
            }
     When
          I send PATCH Request to the Url
     Then
           Status code is 200
           And response body is like   {
                                         "userId": 10,
                                         "title": "Read the books",
                                         "completed": true,
                                         "id": 198
                                        }
  */

    @Test
    public void patch01() {
        //Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data
        Map<String, Object> expectedData = expectedDataMap(null, "Read the books", null);

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("title"), actualData.get("title"));

        //If you need to assert the whole body
        //assertEquals(10, actualData.get("UserId"));
        //assertEquals(true, actualData.get("completed"));


    }
}