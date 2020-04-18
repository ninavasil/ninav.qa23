package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int before=getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletion();
        permanentlyDeleteBoard();
        returnHome();
        int after= getBoardsCount();
        System.out.println("was:"+before+ "now:"+after);
        Assert.assertEquals(after,before-1);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../..//li")).size()-1;
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletion() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void confirm() {
        click(By.xpath("//input[@class='js-confirm full negate']"));
    }

    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../..//li"));

    }
}
