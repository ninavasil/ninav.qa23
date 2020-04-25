package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{

    @Test
    public void testTeamCreation() throws InterruptedException {
        Thread.sleep(5000);
        clickCreateTeam();
        fillingForm("My Testteam", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        writeDescription("This is my first created Team");
        confirmCreation();
        inviteYourTeam();
        returnHome();
    }
    }


