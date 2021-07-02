package ru.stqa.ptf.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static Configs.URLPages.URL_endpoint;
import static org.junit.Assert.assertEquals;

public class ControlRations {

    REST rest = new REST();

    public String takeFile() throws IOException {
        String xml = new String(Files.readAllBytes(Paths.get("src/test/resources/crtxt/CRtest.txt")));
        System.out.println(xml);
        return xml;
    }

    public void postXMLForAssert(String id, String xml) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .contentType(ContentType.JSON)
                .body(xml)
                .post(URL_endpoint + "test/knd/transport-file?declarationId=" + id);
        assertEquals(200, response.getStatusCode());
    }

    public void postErrorReport(String id) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .contentType(ContentType.JSON)
                .post(URL_endpoint + "test/knd/error-report?declarationId=" + id);
        assertEquals(200, response.getStatusCode());
    }

    public String findExcelFile(String id) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .get(URL_endpoint + "declarations/files/list?size=30&page=0&property=id&direction=asc&payload=" + id);
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getJsonObject("payload.id").toString().substring(6, 9);
    }

    public int checkExcelFile(String id) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .get(URL_endpoint + "declarations/files/request/download?id=" + id);
        assertEquals(200, response.getStatusCode());
        return response.getBody().asByteArray().length;
    }
}
