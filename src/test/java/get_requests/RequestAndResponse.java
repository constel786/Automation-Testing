package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestAndResponse {
    /*
    1) Postman is used for manuel API testing
    2) We use Rest Assured Library for API automation testing
    3) To type automation script, follow these steps:
        a) Understand the requirements
        b) Type the test case
           To type test cases, we use Gherkin Language
           The keywords in Gherkin Language:
            x) Given: Used for pre-conditions (eg. Endpoint)
            y) When: Used for actions (eg. Requests)
            z) Then: Used for output (eg. Assertion)
            t) And: Used for multiple usage of keywords
        c) Start to type Automation Script:
            i) Set the URL
            ii) Set the expected data
            iii) Send the request and get the response
            iv) Do Assertion
     */

    /*
  Given
      https://restful-booker.herokuapp.com/booking/10
  When
      User sends a GET Request to the url
  Then
      HTTP Status Code should be 200
  And
      Content Type should be JSON
  And
      Status Line should be HTTP/1.1 200 OK
*/
    public static void main(String[] args) {
//        i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/10";

//        ii) Set the expected data
        //We will do this step later

//        iii) Send the request and get the response
        Response response = given().get(url); //get() method returns a Response
        // To see the response on console, use prettyPrint() method with response object
        // response.prettyPrint(); commented it so we don't see it everytime we run it

//        iv) Do Assertion
        //To do Assertion, we need a testing framework such as HUnit, Test NG, Cucumber, etc.

        //How to get Status Code:
        //All the data that comes from the API is inside the "response"
        //HTTP Status Code should be 200
        System.out.println("Status Code: " + response.statusCode());

        //How to get Content Type:
        //Content Type should be JSON file format
        System.out.println("Content Type: " + response.contentType());

        //How to get Status Line:
        //Status Line should be HTTP/1.1 200 OK
        System.out.println("Status Line: " + response.statusLine());

        //How to get the Header:
        System.out.println(response.header("Date"));
        System.out.println("\nHeaders: ");
        System.out.println(response.headers()); //or just response.header("Server")

        //How to get the Time
        System.out.println("Time: " + response.getTime());

    }
}
