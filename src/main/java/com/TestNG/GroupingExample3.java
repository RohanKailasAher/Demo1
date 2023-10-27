package com.TestNG;

import org.testng.annotations.Test;

public class GroupingExample3 {
    @Test(groups = {"Sanity"})
    public void test1(){
        System.out.println("this is test1...");
    }
    @Test(groups = {"Sanity"})
    public void test2(){
        System.out.println("this is test2...");
    }
    @Test(groups = {"Smoke"})
    public void test3(){
        System.out.println("this is test3...");
    }
    @Test(groups = {"Smoke"})
    public void test4(){
        System.out.println("this is test4...");
    }
    @Test(groups = {"Sanity","Regression"})
    public void test5(){
        System.out.println("this is test5...");
    }
}
