package com.qa.trello.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$='boards']"), 20);
        }
    }
        @Test
        public void testTeamCreation () throws InterruptedException {
            Thread.sleep(5000);
            app.getTeam().clickCreateTeam();
            app.getTeam().fillingForm("My Testteam", By.cssSelector("[class='_38pq5NbRWAG39y']"));
            //  app.getTeam().writeDescription("This is my first created Team");
            app.getTeam().confirmCreation();
            app.getTeam().createTeamLater();
           // app.getTeam().inviteYourTeam();
            app.getTeam().returnHome();
        }
    }



