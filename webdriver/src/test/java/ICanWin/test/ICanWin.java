package ICanWin.test;

import ICanWin.pages.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ICanWin {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Checking new paste creation")
    public void checkNewPasteCreation() {
        Assert.assertTrue(new PastebinHomePage(driver)
                .openPage()
                .codePaste()
                .setPasteExpiration()
                .setPasteNameTitle()
                .createNewPaste()
                .checkOfSuccessfulNewPasteCreation());
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}

