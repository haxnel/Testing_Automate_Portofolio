package com.Automate.Web;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WebAll {

    By login = By.cssSelector("#login2");
    By userInput = By.cssSelector("#loginusername");
    By passInput = By.cssSelector("#loginpassword");
    By tombolLogin = By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary");
    By namaUser = By.cssSelector("#nameofuser");

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
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.elementToBeClickable(userInput));
        driver.findElement(userInput).sendKeys(user);
    }
    public void inputPass(String pass){
        driver.findElement(passInput).sendKeys(pass);
    }
    public void ClickLogin(){
        driver.findElement(tombolLogin).click();
    }
    public void nameOFuser(String user){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(namaUser));
        Assertions.assertTrue(driver.getPageSource().contains(user));
    }
    public void popUp (String pop) throws InterruptedException {
        Thread.sleep(1000);
        String text = driver.switchTo().alert().getText();
        Assertions.assertEquals(text, pop);
        driver.switchTo().alert().accept();
    }

}
