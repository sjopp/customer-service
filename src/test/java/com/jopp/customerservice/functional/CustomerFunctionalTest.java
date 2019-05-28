package com.jopp.customerservice.functional;

import com.jayway.restassured.RestAssured;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerFunctionalTest {

    private static final String getCustomerUrl = "/customer";
    private static final String getCustomersUrl = "/customers";
    private static final String addCustomerUrl = "/customer/add";

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
    public void testResponseOfGettingAllCustomersController() {
        given().
            header("Content-Type", "application/json").
        when().
           get("/customers").
        then().
           statusCode(200).
        and().
           body("data.customers[0].fullName", equalTo("Tim Bob"),
                   "data.customers[0].dateOfBirth", equalTo("1966/09/19"),
                   "data.customers[1].fullName", equalTo("Bill Will"),
                   "data.customers[1].dateOfBirth", equalTo("1956/07/11"));
    }

    @Test
    public void testResponseOfGettingACustomerController() {

        String username = "sjopp";
        String parametrisedUrl = String.format("%s/%s", getCustomerUrl, username);

        given().
           header("Content-Type", "application/json").
        when().
           get(parametrisedUrl).
        then().
           statusCode(200).
        and().
           body("data.customer.fullName", equalTo("Sam Jopp"),
                   "data.customer.dateOfBirth", equalTo("1995/09/15"),
                   "data.exists", equalTo(true));
    }

//    @Ignore
    @Test
    public void testWeGet201ResponseWhenAddingACustomer() {
        given().
           port(port).
           body(readFileFromContents("customer-request.json")).
           header("Accept", "application/json;charset=UTF-8").
           header("Content-Type", "application/json;charset=UTF-8").
        when().
           post("/customer/add").
        then().
           statusCode(201);
    }

    private String readFileFromContents(String fileName) {
        InputStream resource = null;
        String fixtureContents = "";
        try {
            resource = new ClassPathResource(String.format("json/%s", fileName)).getInputStream();
            fixtureContents = IOUtils.toString(resource, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fixtureContents;
    }
}
