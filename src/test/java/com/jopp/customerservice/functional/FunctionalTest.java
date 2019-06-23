package com.jopp.customerservice.functional;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract class FunctionalTest {

    protected String readFileFromContents(String fileName) {
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
