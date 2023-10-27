package com.Basics;

import org.testng.annotations.Test;

public class FirstTestCase {
    @Test(priority = 1)
    public void setup(){
        System.out.println("opening browser");
    }
    @Test(priority = 2)
    public void login(){
        System.out.println("This is login test");
    }
    @Test(priority = 3)
    public void teardown(){
        System.out.println("closing browser");
    }
}
