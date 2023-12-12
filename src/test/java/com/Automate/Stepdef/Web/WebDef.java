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

    @And("User Click {string}")
    public void userClickSignUp(String sign) {
        webAll.tombolBuat(sign);
    }

    //Delete product//
    @And("User Click {string} barang")
    public void userClickSalahSatuBarang(String barang) throws InterruptedException {
        webAll.userClickSalahSatuBarang(barang);
    }

    @And("User click cart")
    public void userClickCart() throws InterruptedException {
        webAll = new WebAll(driver);
        webAll.clickcart();
    }

    //---End----//

    //Purchase
    @And("Click Place order")
    public void clickPlaceOrder(){
        webAll.clickPlaceOrder();
    }

    @And("User mengisi form dengan {string}, {string}, {string}, {string}, {string}, dan {string}")
    public void userMengisiFormDenganDan(String name, String country, String city, String credit, String month, String year) {
        webAll.userMengisiFormDenganDan(name,country,city,credit,month,year);
    }

    @When("click tombol Purchase")
    public void clickTombolPurchase() {
        webAll.clickTombolPurchase();
    }

    @Then("Menampilkan pop up {string}")
    public void menampilkanPopUp(String pembayaran) throws InterruptedException {
        webAll.menampilkanPopUpPembayaran(pembayaran);
    }

    @Then("User tidak dapat melanjutkan dan melihat tulisan {string}")
    public void userTidakDapatMelanjutkanDanMelihatTulisan(String err) throws InterruptedException {
        webAll.errorPurchase(err);
    }
}
