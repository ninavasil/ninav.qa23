package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class OpenGoogleTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.google.com/");
    }

    @Test
    public void testOpenGoogle(){
        click(By.className("gb_D"));
        click(By.className("gb_D"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @Test
    public void testSearchGoogle() throws InterruptedException {
        click(By.name("q"));
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("Java");

        Thread.sleep(3000);
    }

    @Test
    public void testOpenProfile() throws InterruptedException {
        click(By.id("gb_70"));

        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown(){
       wd.quit();
    }
}
