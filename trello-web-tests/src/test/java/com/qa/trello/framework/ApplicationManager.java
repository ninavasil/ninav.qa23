package com.qa.trello.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    Boardhelper board;
    Teamhelper team;
    Sessionhelper session;
    WebDriverWait wait;


    public void init() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        session=new Sessionhelper(wd);
        Thread.sleep(5000);
        session.loginAtlasian("lika-ki@mail.ru", "VsjoHorosho11");

        board= new Boardhelper(wd);
        team=new Teamhelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public Boardhelper getBoard() {
        return board;
    }

    public Teamhelper getTeam() {
        return team;
    }

    public Sessionhelper getSession() {
        return session;
    }
}