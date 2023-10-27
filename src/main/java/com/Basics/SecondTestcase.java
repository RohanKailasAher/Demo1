package com.Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestcase {
    @Test(priority = 1)
    public void setup(){
        System.out.println("opening browser");
    }
    @Test(priority = 3)
    public void SearchCustomer(){
        System.out.println("This is Search Customer test");
        Assert.assertEquals("A","B");
    }
    @Test(priority = 2)
    public void AddCustomer(){
        System.out.println("This is Add Customer test");
    }
    @Test(priority = 4)
    public void teardown(){
        System.out.println("closing browser");
    }}
