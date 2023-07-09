package gmibank_api;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPost;
import pojos.State;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreateCountry extends GmiBankBaseUrl {
/*
When
    https://gmibank.com/api/tp-countries
And
{
  "name": "Banana Republic",
  "states": [
    {
      "id": 0,
      "name": "Apple"
    },
     {
      "id": 1,
      "name": "Orange"
    },
     {
      "id": 2,
      "name": "Peach"
    }
  ]
}
When
    Send post request
Then
    Status code is 201
And


 */

@Test
public void post01(){
    //Set the Url
    spec.pathParams("first", "api", "second", "tp-countries");

    //Set the expected data
    State state1 = new State(0, "Apple");
    State state2 = new State(1, "Orange");
    State state3 = new State(2, "Peach");
    List<State> stateList = new ArrayList<>();
    stateList.add(state1);
    stateList.add(state2);
    stateList.add(state3);
    System.out.println("stateList = " + stateList);

    CountryPost expectedData = new CountryPost("Banana Republic", stateList);
    System.out.println("expectedData = " + expectedData);
    
    //Send the request and get the response
    Response response = given(spec).body(expectedData).post("{first}/{second}");
    response.prettyPrint();

    //Do assertion
    //1st Validation
    response
            .then()
            .statusCode(201)
            .body("name", equalTo(expectedData.getName()),
                    "states.id[0]", equalTo(state1.getId()),
                    "states.name[0]", equalTo(state1.getName()),
                    "states.id[1]", equalTo(state2.getId()),
                    "states.name[1]", equalTo(state2.getName()),
                    "states.id[2]", equalTo(state3.getId()),
                    "states.name[2]", equalTo(state3.getName())
            );



}

}
