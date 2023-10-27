package com.FirstTestNG.Package;

import org.testng.annotations.*;

public class Basics {
    /*
@BeforeSuite----Chrome driver setup--1
@BeforeTest---launchBrowser---2
@BeforeClass---login to app---3
@BeforeMethod---enter the url---4
@Test---google logo test
@AfterMethod---logout to app
@BeforeMethod---enter the url
@Test---google title test
@AfterMethod---logout to app
BeforeMethod---enter the url
@Test---search test
@AfterMethod---logout to app
@AfterClass---close the browser
@AfterTest---Delete all the cookies
@AfterSuite---generateReport

*/




    //Pre-Condition Annotation-----Starting with @Before
    @BeforeSuite//1
    public void setup(){
        System.out.println(" @BeforeSuite----Chrome driver setup");
    }
    @BeforeTest//2
    public void launchBrowser(){

        System.out.println("BeforeTest---launchBrowser");
    }
    @BeforeClass//3
    public void login(){
        System.out.println("BeforeClass---login to app");
    }
    /*
   @BeforeMethod
   @Test-1
   @AfterMethod

   @BeforeMethod
   @Test-2
   @AfterMethod

   @BeforeMethod
   @Test-3
   @AfterMethod
    * */
    @BeforeMethod//4
    public void enterURl(){
        System.out.println("BeforeMethod---enter the url");
    }
    //test cases----starting with @Test
    @Test//5
    public void googleTitle(){
        System.out.println("@Test---google title test");
    }
    @Test
    public void searchTest(){
        System.out.println("@Test---search test");
    }
    @Test
    public void GoogleLogo(){
        System.out.println("@Test---google logo test");
    }
    //these are post condition----starting with @After
    @AfterMethod//6
    public void logout(){
        System.out.println("@AfterMethod---logout to app");
    }
    @AfterClass//7
    public void CloseBrowser(){
        System.out.println(" @AfterClass---close the browser");
    }
    @AfterTest//8
    public void DeleteAllCookies(){
        System.out.println(" @AfterTest---Delete all the cookies");
    }

    @AfterSuite//9
    public void generateReport(){
        System.out.println("@AfterSuite---generateReport");
    }

}
