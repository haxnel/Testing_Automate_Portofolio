package com.Automate.Api;

import com.Automate.utilitas.Endpoint;
import com.Automate.utilitas.Model;
import com.Automate.utilitas.schema;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.io.File;
import java.util.List;


public class AllApi {
    long max = 60000; //dalam milliseconds
    String SetURL;
    Response response;

    public void mempersiapkanURLUntuk(String url){
        //------GET-------//
        if (url.equals("GET users")) {
            SetURL = Endpoint.GET_user;
            System.out.println("Endpoint disiapkan: " + SetURL);
            response = Model.GET_HIT(SetURL);
        } else if (url.equals("GET single users")) {
            SetURL = Endpoint.GET_Singleuser;
            System.out.println("Endpoint disiapkan: " + SetURL);
            response = Model.GET_HIT(SetURL);
        } else if (url.equals("GET tags list")) {
            SetURL = Endpoint.GET_Tag;
            System.out.println("Endpoint disiapkan: " + SetURL);
            response = Model.GET_HIT(SetURL);
        }
        //-----END-------//
        //------POST-------//
        else if (url.equals("Post users")) {
            SetURL = Endpoint.POST_user;
            System.out.println("Mempersiapkan url: " + SetURL);
            response = Model.POST_Users(SetURL);
        } else if (url.equals("Post users already created")) {
            SetURL = Endpoint.POST_user;
        }
        //-----END-------//
        //------Update User-------//
        else if (url.equals("Update user")) {
            SetURL = Endpoint.UPDATE_user;
            System.out.println("Mempersiapkan url: " + SetURL);
            response = Model.UPDATE_Users(SetURL);
        }
        //-----END-------//
        //------Delete User-------//
        else if (url.equals("Delete user")) {
            SetURL = Endpoint.DELETE_user;
            System.out.println("Mempersiapkan url: " + SetURL);
            response = Model.DELETE_user(SetURL);
        }
        //-----END-------//
        else {
            System.out.println("Tidak ada endpoint yang digunakan");
        }
    }
    public void mendapatkanStatusCode(int code){
        response.then()
                .assertThat().time(Matchers.lessThan(max))
                .assertThat().statusCode(code);

        System.out.println("Status code yang didapat: " + response.statusCode());
    }
    public void memvalidasiResponsJsonDenganJSONSchema(String valid){
        File jsonFile = schema.mendapatkanFILEJSON_schemaAPI(valid);
        response.then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
        System.out.println("Keluaran: " + jsonFile);
    }
    //GET USER, SINGLE USER, TAGS
    public void hitAPIUntukMendaptakanListUser(){
        response.then().log().all();
    }
    public void memvalidasiResponsBodyUserYangDidapat(int num){
        response.then()
                .assertThat().body("page", Matchers.equalTo(num));
    }
    public void memvalidasiResponsBodyUserYangDidapatId(String id){
        response.then()
                .assertThat().body("id", Matchers.equalTo("60d0fe4f5311236168a10a2d"));
    }
    public void memvalidasiResponsBodyUserYangDidapatPadaTag(String tag){
        response.then()
                .assertThat().body(tag, Matchers.instanceOf(List.class));
    }
    //POST and UPDATE user
    public void terdapatDanDiBody(String date, String update){
        response.then()
                .assertThat().body("$", Matchers.hasKey(date))
                .assertThat().body("$", Matchers.hasKey(update));
    }
    //DELETE User
    public void terdapatError(String error){
        if (error.equals("error")) {
            response.then()
                    .assertThat().body("$", Matchers.hasKey(error));
        } else if (error.equals("id")){
            response.then()
                    .assertThat().body("$", Matchers.hasKey(error));
        } else {
            System.out.println("Tidak ada masukan");
        }
    }
}
