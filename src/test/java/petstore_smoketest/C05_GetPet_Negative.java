package petstore_smoketest;

import base_urls.PetStoreBaseUrl;
import org.junit.Test;

public class C05_GetPet_Negative extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/3465589
    When
        Send get request
    Then
        Status code is 404
    And
        Response body is:
        {
            "code": 1,
            "type": "error",
            "message": "Pet not found"
        }
     */
    @Test
    public void get02(){
        //Set the url




    }
}



