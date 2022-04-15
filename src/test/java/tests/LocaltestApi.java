package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class LocaltestApi {

    @Test(enabled = false)
    public void get(){
        baseURI = "http://localhost:3000";
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(enabled = false)
    public void post(){
        JSONObject request = new JSONObject();
        request.put("name", "Automation Architect");
        request.put("Id", 2);
        System.out.println(request);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/subjects")
                .then()
                .statusCode(201)
                .log().all();

    }
    @Test(enabled = true)
    public void post1(){
        JSONObject request = new JSONObject();
        request.put("firstname", "Kanak");
        request.put("lastname","Puri");
        request.put("subjectId", 3);
        System.out.println(request);
        baseURI = "http://localhost:3000";
        given()
               // .header("Content-Type","application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
                //.log().all();

    }
    @Test(enabled = true)
    public void put(){
        JSONObject request = new JSONObject();
        request.put("firstname", "Vishal");
        request.put("lastname","Patel");
        //request.put("subjectId", 1);
        System.out.println(request);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
