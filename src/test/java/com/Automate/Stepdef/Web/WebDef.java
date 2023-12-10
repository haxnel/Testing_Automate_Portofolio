package com.Automate.Stepdef.Web;

import com.Automate.BaseTest;
import com.Automate.Web.WebAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class WebDef extends BaseTest {

    WebAll webAll;

    @Given("User berada pada home page")
    public void userBeradaPadaHomePage() {
        webAll = new WebAll(driver);
        webAll.driverHome();
    }

    @And("User click Login")
    public void userClickLogin() {
        webAll.LoginUser();
    }

    @And("User memasukan username {string}")
    public void userMemasukanUsername(String name) {
        webAll.inputUser(name);
    }

    @And("User memasukan password {string}")
    public void userMemasukanPassword(String pass) {
        webAll.inputPass(pass);
    }

    @When("User click tombol login")
    public void userClickTombolLogin() {
        webAll.ClickLogin();
    }

    @Then("User dapat melihat akun masuk dengan {string}")
    public void userDapatMelihatAkunMasukDengan(String nameuser) {
        webAll.nameOFuser(nameuser);
    }

    @Then("Muncul pop up dengan tulisan {string}")
    public void munculPopUpDenganTulisan(String pop) throws InterruptedException {
        webAll.popUp(pop);
    }
}