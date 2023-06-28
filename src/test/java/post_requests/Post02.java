package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrl {
    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
            I send POST Request to the URL
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post02() {
        //Set the URL
        spec.pathParam("first", "todos");

        //Set the expected data
        //We can set the payload by using Map --> This is recommended because we can get the data from the expected data in assertion part dynamically
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        //We need a serializer to convert Java Object to JSON --> From Java to JSON: Serialization
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        //To do assertion we need 2 data in the same type. We need to convert Json response into Java object.
        //To convert Json to Java object --> De-Serialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
    }

        //We did not use any hard codding in assertion part

        @Test
        public void post02b () {
            //Set the url
            spec.pathParam("first", "todos");

            //Set the expected data
            Map<String, Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(55, "Tidy your room", false);
            System.out.println("expectedData = " + expectedData);

            //Send the request and get the response
            Response response = given(spec).body(expectedData).post("{first}");
            response.prettyPrint();

            //Do assertion
            Map<String, Object> actualData = response.as(HashMap.class);
            System.out.println("actualData = " + actualData);

            assertEquals(expectedData.get("completed"), actualData.get("completed"));
            assertEquals(expectedData.get("userId"), actualData.get("userId"));
            assertEquals(expectedData.get("title"), actualData.get("title"));
            //We did not use any hard codding in assertion part
        }

}
