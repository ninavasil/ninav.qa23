package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://mail.ru/");

    }

    @Test
    public void testLoginJira() throws InterruptedException {
        click(By.name("login"));
        wd.findElement(By.name("login")).clear();
        wd.findElement(By.name("login")).sendKeys("lika-ki");
        click(By.className("o-control"));
        click(By.name("password"));
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("VsjoHorosho");
        click(By.className("o-control"));
        Thread.sleep(3000);
    }


    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}