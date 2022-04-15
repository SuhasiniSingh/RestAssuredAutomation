package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
//import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOne {
    @Test(enabled = false)
    public void get_test(){

        baseURI="https://reqres.in/api";
     given()
             .when()
             .get("/users?page=2")
             .then()
             .statusCode(200)
             .body("data[1].id",equalTo(8))
             .body("data.first_name",hasItems("George","Rachel"))
             .log().all();
        System.out.println("first api test");
    }
    @Test(enabled = true)
    public void post_test(){

        /*Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","Virat");
        map.put("job","student");*/
        JSONObject request = new JSONObject();
        request.put("name","Vishnu");
        request.put("job","Student");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";
        given()
               .header("Content-Type","application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }
    @Test(enabled = false)
    public void put_test(){
        JSONObject request = new JSONObject();
        request.put("name","Shivank");
        request.put("job","Student");

        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test(enabled = false)
    public void delete_test(){
        baseURI ="https://reqres.in";
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log().all();

    }
}
