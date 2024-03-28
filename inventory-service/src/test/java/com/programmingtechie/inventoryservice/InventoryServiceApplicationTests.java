package com.programmingtechie.inventoryservice;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldReadInventory() {
        var expectedResponseBody = """
                [
                    {
                        "skuCode": "iphone_15",
                        "isInStock": true
                    },
                    {
                        "skuCode": "pixel_8",
                        "isInStock": true
                    }
                ]
                """;
        RestAssured.given()
                .when()
                .get("/api/inventory?skuCodes=iphone_15&skuCodes=pixel_8")
                .then()
                .log().all()
                .statusCode(200)
                .body("$.size()", Matchers.is(2))
                .body(Matchers.equalTo(JsonPath.parse(expectedResponseBody).jsonString()));
    }

}
