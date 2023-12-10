package com.Automate.Stepdef.Api;

import com.Automate.Api.AllApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class APIDef {
    AllApi allApi;

    public APIDef(){
        allApi = new AllApi();
    }

    @Given("Mempersiapkan URL untuk {string}")
    public void mempersiapkanURLUntuk(String url) {
        allApi.mempersiapkanURLUntuk(url);
    }

    @And("Hit API untuk mendaptakan list")
    public void hitAPIUntukMendaptakanList() {
        allApi.hitAPIUntukMendaptakanListUser();
    }

    @Then("Mendapatkan status code {int}")
    public void mendapatkanStatusCode(int code) {
        allApi.mendapatkanStatusCode(code);
    }

    @Then("Memvalidasi respons json dengan JSONSchema {string}")
    public void memvalidasiResponsJsonDenganJSONSchema(String arg0) {
        allApi.memvalidasiResponsJsonDenganJSONSchema(arg0);
    }

    //---- Check method GET ALL USERS, SINGLE USERS, AND TAG ----//
    @Then("Memvalidasi respons body user yang didapat page {int}")
    public void memvalidasiResponsBodyUserYangDidapatPage(int page) {
        allApi.memvalidasiResponsBodyUserYangDidapat(page);
    }
    @Then("Memvalidasi respons body user yang didapat id {string}")
    public void memvalidasiResponsBodyUserYangDidapatId(String id) {
        allApi.memvalidasiResponsBodyUserYangDidapatId(id);
    }
    @Then("Memvalidasi respons body user yang didapat {string} pada tag")
    public void memvalidasiResponsBodyUserYangDidapatPadaTag(String arg0) {
        allApi.memvalidasiResponsBodyUserYangDidapatPadaTag(arg0);
    }
    //-------------END-------------//
    //---- Check POST NEW USERS and UPDATE USER ----//
    @Then("Terdapat {string} dan {string}")
    public void terdapatDan(String date, String update) {
        allApi.terdapatDanDiBody(date,update);
    }
    //-------------END-------------//
    @Then("Terdapat {string} di body")
    public void terdapatDiBody(String err) {
        allApi.terdapatError(err);
    }
}
