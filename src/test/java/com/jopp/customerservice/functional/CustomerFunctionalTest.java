package com.jopp.customerservice.functional;

import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerFunctionalTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testResponseOfController() {
        given().
           port(port).
        when().
           get("/customers").
        then().
           statusCode(200).
        and().
           body("response.customers[0].fullName", equalTo("Tim Bob"),
                   "response.customers[0].dateOfBirth", equalTo("1966/09/19"),
                   "response.customers[1].fullName", equalTo("Bill Will"),
                   "response.customers[1].dateOfBirth", equalTo("1956/07/11"));
    }
}
