package BringItOn.test;

import BringItOn.pages.PastebinHomePage;
import BringItOn.pages.PastebinNewPastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

public class BringItOn {
    private WebDriver driver;
    private PastebinNewPastePage pastebinNewPastePage;

    @BeforeClass(alwaysRun = true)
    public void openNewPageWithPasteParameters() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinNewPastePage = new PastebinHomePage(driver).openPage()
                .codePaste()
                .setSyntaxHighlighting()
                .setPasteExpiration()
                .setPasteNameTitle()
                .createNewPaste();
    }

    @Test(description = "Проверка заголовка")
    public void checkTitle() {
        assertEquals(pastebinNewPastePage.getTitle(), PastebinHomePage.getPasteName(),
                "Заголовки не идентичны!");

    }

    @Test(description = "Проверка подсветки синтаксиса")
    public void checkSyntaxHighlight() {
        assertEquals(pastebinNewPastePage.getTextFromSyntaxHighlightButton(),
                PastebinHomePage.getSyntaxHighlighting(),
                "Значение синтаксиса не совпадает!");
    }

    @Test(description = "Проверка кода")
    public void checkCode() {
        assertEquals(pastebinNewPastePage.getCode(), PastebinHomePage.getCode(),
                "Текст кода не совпадает!");
    }


    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
