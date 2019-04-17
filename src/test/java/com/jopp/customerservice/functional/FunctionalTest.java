package com.jopp.customerservice.functional;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.After;
import org.junit.Before;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.jayway.restassured.RestAssured.get;

abstract class FunctionalTest {

    WireMockServer wireMockServer;

    @Before
    public void setUp() {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }

    @After
    public void teardown() {
        wireMockServer.stop();
    }

    public void setupStub() {

    }
}
