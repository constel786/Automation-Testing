package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04() {
        //i) Set the url
        //String url = "https://jsonplaceholder.typicode.com/todos"; ==> This usage is not recommended. We will put base url into request specification in the base_url package.
        //To be able to reach spec object we need to extend to the related class.
        spec.pathParam("first", "todos"); //With pathParam() method, we add the parameters to the base URL
        //"first" named parameter represents the "todos" parameter in the endpoint.

        //ii) Set the expected data

        //iii) Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //iv) Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", hasSize(200),
                        "title", hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2, 7, 9));

        /*
        If response body returns as a list:
        We can check list size with hasSize() method
        We can check if the list contains an item with hasItem() method
        We can check if the list contains multiple items with hasItems() method
         */
    }
}
