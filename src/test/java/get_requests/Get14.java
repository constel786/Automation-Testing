package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class Get14 extends DummyRestApiBaseUrl {

    /*
Given
    https://dummy.restapiexample.com/api/v1/employees
When
    User sends Get Request to the Url
Then
    Status code is 200
And
    There are 24 employees
And
    "Tiger Nixon" and "Garrett Winters" are among the employees
And
    The greatest age is 66
And
    The name of the lowest age is "[Tatyana Fitzpatrick]"
And
    Total salary of all employees is 6,644,770
 */

@Test
    public void get14(){

    //Set the Url
    spec.pathParam("first", "employees");

    //Set the expected data


    //Send the request and get the response
    Response response = given(spec).get("{first}");
    response.prettyPrint();

    //Do assertion
    response.then()
            .statusCode(200)
            .body("data", hasSize(24),
                    "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));
    //The greatest age is 66
    List<Integer> ages = response.jsonPath().getList("data.employee_age");
    System.out.println("ages = " + ages);
    Collections.sort(ages);
    System.out.println("ages = " + ages);

    assertEquals(66, ages.get(ages.size())-1);


}

}
