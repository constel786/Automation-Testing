package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class Post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
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
    public void post01() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data --> Payload --> The data to transfer
        //We can create the payload by String but it is not Recommended! Because it is not going to be dynamic to get the data in assertion.
        String expectedData = " {\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}";

        //Send the request and get the response
        //In sending post request, the contentType must be declared..

    }
}
