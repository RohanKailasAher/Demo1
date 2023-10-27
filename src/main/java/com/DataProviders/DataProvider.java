package com.DataProviders;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "LoginDataProvider")
    public Object[][] getData(){

        Object[][] data = {{"abc@gamil.com","abc"},{"xyz@gmail.com","xyz"},{"pqr@gmail.com","pqr"}};
        return data;
    }
    @Test(dataProvider = "LoginDataProvider") //dataProviderClass = CustomDataProvider.class
    public void LoginTest(String email, String pwd)
    {
        System.out.println(email+" "+pwd);
    }

}
