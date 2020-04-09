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
        wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

   @Test
    public void testLoginJira() throws InterruptedException {
       click(By.name("os_username"));
       wd.findElement(By.name("os_username")).clear();
       wd.findElement(By.name("os_username")).sendKeys("ninav");
       click(By.name("os_password"));
       wd.findElement(By.name("os_password")).clear();
       wd.findElement(By.name("os_password")).sendKeys("VsjoHorosho");
       click(By.name("login"));
       Thread.sleep(3000);
   }
//   @Test
//   public void testLogOut() throws InterruptedException {
//        wd.findElement(By.className("aui-avatar aui-avatar-small")).click();
//        Thread.sleep(3000);
//        click(By.id("log_out"));
//   }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
