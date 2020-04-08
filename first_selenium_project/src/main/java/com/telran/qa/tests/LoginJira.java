package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
    WebDriver wd;

    @BeforeClass
            public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

   @Test
    public void testLoginJira(){
        wd.findElement(By.name("os_username")).click();
        wd.findElement(By.name("os_username")).clear();
        wd.findElement(By.name("os_username")).sendKeys("ninav");
        wd.findElement(By.name("os_password")).click();
        wd.findElement(By.name("os_password")).clear();
        wd.findElement(By.name("os_password")).sendKeys("VsjoHorosho");
        wd.findElement(By.name("login")).click();

   }
}
