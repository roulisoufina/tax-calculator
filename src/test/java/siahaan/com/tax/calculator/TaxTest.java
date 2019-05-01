/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author roulis
 */
public class TaxTest {
    
    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8082;
    }
    
//    @Test
    public void whenUsePathParam_thenOK(){
        given().queryParam("phone", "081212345")
                .when()
                .get("/tax/bill")
                .then()
                .statusCode(200);
    }
    
    //phone not found will return 404
//    @Test
    public void whenRequestedPost_thenCreatedFailed(){
        Map<String, Object> request = new HashMap<>();
        request.put("tax_code", "1");
        request.put("name", "test fake");
        request.put("price", 1000);
        given().contentType("application/json")
                .header("phone", "081211111")
                .body(request)
                .when()
                .post("/tax/create")
                .then()
                .statusCode(404);
    }
    
    //pattern taxCode is invalid will return 400
//    @Test
    public void whenRequestedPost_thenCreatedFailedPattern(){
        Map<String, Object> request = new HashMap<>();
        request.put("tax_code", "test1");
        request.put("name", "test fake");
        request.put("price", 1000);
        given().contentType("application/json")
                .header("phone", "081212345")
                .body(request)
                .when()
                .post("/tax/create")
                .then()
                .statusCode(400);
    }
    
//    @Test
    public void whenRequestedPost_thenCreated() {
        Map<String, Object> request = new HashMap<>();
        request.put("tax_code", "1");
        request.put("name", "test fake");
        request.put("price", 1000);
        given().contentType("application/json")
                .header("phone", "081212345")
                .body(request)
                .when()
                .post("/tax/create")
                .then()
                .statusCode(200);
    }
    
    
}
