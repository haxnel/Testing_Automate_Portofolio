package com.Automate.Web;

import com.Automate.utilitas.geneAccount;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WebAll {

    By login = By.cssSelector("#login2");
    By userInputLogin = By.cssSelector("#loginusername");
    By passInputLogin = By.cssSelector("#loginpassword");
    By userinputSign = By.cssSelector("#sign-username");
    By passinputSign = By.cssSelector("#sign-password");
    By tombolLogin = By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary");
    By namaUser = By.cssSelector("#nameofuser");
    By clickSignup1 = By.cssSelector("#signin2");
    By clickSignUp2 = By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary");

    WebDriver driver;

    public WebAll(WebDriver driver){
        this.driver = driver;
    }

    public void driverHome(){
        driver.get("https://www.demoblaze.com/");
    }
    public void LoginUser (){
        driver.findElement(login).click();
    }
    public void inputUser(String user){
        if (user.equals("User baru")){
            String nama = geneAccount.userBaruakun();
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            wait.pollingEvery(Duration.ofMillis(100));
            wait.until(ExpectedConditions.elementToBeClickable(userinputSign));
            driver.findElement(userinputSign).sendKeys(nama);
        } else if(user.equals("testiop")) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            wait.pollingEvery(Duration.ofMillis(100));
            wait.until(ExpectedConditions.elementToBeClickable(userInputLogin));
            driver.findElement(userInputLogin).sendKeys(user);
        } else if (user.equals("asdkiiek")) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            wait.pollingEvery(Duration.ofMillis(100));
            wait.until(ExpectedConditions.elementToBeClickable(userinputSign));
            driver.findElement(userinputSign).sendKeys(user);
        } else {
            System.out.println("Masukan nama user");
        }

    }
    public void inputPass(String pass){
        if (pass.equals("Pass baru")){
            String kunci = geneAccount.userBaruakun();
            driver.findElement(passinputSign).sendKeys(kunci);
        } else if(pass.equals("testing")) {
            driver.findElement(passInputLogin).sendKeys(pass);
        } else if (pass.equals("asdasdas")){
            driver.findElement(passInputLogin).sendKeys(pass);
        } else {
            driver.findElement(passinputSign).sendKeys(pass);
        }
    }
    public void ClickLogin(){
        driver.findElement(tombolLogin).click();
    }
    public void nameOFuser(String user){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(namaUser));
        Assertions.assertTrue(driver.getPageSource().contains(user));
    }
    public void popUp (String pop) throws InterruptedException {
        Thread.sleep(1000);
        String text = driver.switchTo().alert().getText();
        Assertions.assertEquals(text, pop);
        driver.switchTo().alert().accept();
    }

    //SignUp
    public void tombolBuat(String buat){
        if (buat.equals("Sign up 1")){
            driver.findElement(clickSignup1).click();
        } else if (buat.equals("Sign up 2")){
            driver.findElement(clickSignUp2).click();
        } else {
            System.out.println("Tolong tekan tombol sign up");
        }
    }

    //Checkout
    public void userClickSalahSatuBarang() {
        By barang1 = By.cssSelector("#tbodyid > div:nth-child(1)");
        By barang2 = By.cssSelector("#tbodyid > div:nth-child(6) > div > div > h4 > a");
        By next = By.cssSelector("#next2");
        By place = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
        By home = By.cssSelector("#navbarExample > ul > li.nav-item.active > a");
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofSeconds(20));


        wait.until(ExpectedConditions.elementToBeClickable(barang1));
        driver.findElement(barang1).click();
        wait.until(ExpectedConditions.elementToBeClickable(place));
        driver.findElement(place).click();

        driver.findElement(home).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(next));
        driver.findElement(next).click();

        wait.until(ExpectedConditions.elementToBeClickable(barang2));
        driver.findElement(barang2).click();
        wait.until(ExpectedConditions.elementToBeClickable(place));
        driver.findElement(place).click();
    }

    public void clickcart(){
        By cart = By.cssSelector("#cartur");
        driver.findElement(cart).click();
    }

    public void delete_cart() {
        By delete = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a");
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(delete));
        driver.findElement(delete).click();
        driver.findElement(delete).click();
    }

    public void validasiCheck () {
        By val = By.cssSelector("#tbodyid");
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(val));
        Assertions.assertFalse(driver.findElement(val).getText().contains("Samsung galaxy s6"));

    }
}
