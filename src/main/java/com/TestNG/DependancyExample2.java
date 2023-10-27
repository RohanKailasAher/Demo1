package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyExample2 {
    @Test
    public void startCar(){
        System.out.println("Car Started");
       // Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})
    public void driveCar(){
        System.out.println("Car Driving");
    }
    @Test(dependsOnMethods = {"driveCar"})
    public void stopCar(){
        System.out.println("Car Stopped");
    }
    @Test(dependsOnMethods = {"driveCar","stopCar"},alwaysRun = true)
    public void parkCar(){
        System.out.println("Car Parked");
    }
}
