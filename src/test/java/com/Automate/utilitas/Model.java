package com.Automate.utilitas;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Model {
    private static RequestSpecification request;
    static String appkey = "656ed3cfc5535fccfc422f7c";

    public static void setupHeaders(){
        request =  RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", appkey);
    }
    public static Response GET_HIT(String endpoint){
        setupHeaders();
        return request.get(endpoint);
    }
    public static Response POST_Users(String endpoint){
        //Pembuatan object Body
        String first = geneAccount.createName();
        String last = geneAccount.createName();
        String email = geneAccount.createEmail();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", first);
        jsonObject.put("lastName", last);
        jsonObject.put("email", email);
        setupHeaders();
        return request.body(jsonObject.toString()).post(endpoint);
    }

    public static Response UPDATE_Users(String endpoint){
        //Pembuatan object Body
        String first = geneAccount.createName();
        String last = geneAccount.createName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", first);
        jsonObject.put("lastName", last);
        setupHeaders();
        return request.body(jsonObject.toString()).put(endpoint);
    }

    public static Response DELETE_user(String endpoint){
        setupHeaders();
        return request.delete(endpoint);
    }

}
