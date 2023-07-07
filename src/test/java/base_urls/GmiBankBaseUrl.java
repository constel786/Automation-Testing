package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {
    //This class is created to prevent repeated actions in requests like baser url, content type, authorization, etc.

    protected RequestSpecification spec;

    @Before //This annotation runs the method before each @Test method. Then spec object will be assigned.
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg4ODI4NTQwfQ.n6a-Gdwn-oVxYKPwq7HCSHK9pvhbhiY_zrjTw8aVnwOqH6umfBmUW6aSJxe1zzmvuQQ9X1gXGJCgVWEmz0Vrew")
                .setBaseUri("https://www.gmibank.com")
                .build();


    }
}
