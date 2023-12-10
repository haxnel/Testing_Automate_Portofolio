package com.Automate;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest{
    @Before
    public void beforeTes(){
        GetDriver();
    }
    @After
    public void afterTes(){
        driver.close();
    }
}
