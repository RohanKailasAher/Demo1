package com.TestNG;

import org.testng.annotations.Test;

public class PriorityExample1 {
    @Test(priority = 0)
    public void TestOne(){
        System.out.println("this is test1...");
    }
    @Test(priority = 1,enabled = false)
    public void TestTwo(){
        System.out.println("this is test2...");
    }
    @Test(priority = 4,enabled = false)
    public void TestThree(){
        System.out.println("this is test3...");
    }
    @Test(priority = 3)
    public void TestFour(){
        System.out.println("this is test4...");
    }
}
