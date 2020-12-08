package BringItOn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PastebinHomePage {
    private static final String PAGE_URL = "https://pastebin.com";
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String SYNTAX_HIGHLIGHTING = "Bash";
    private static final String PASTE_NAME_TITLE = "how to gain dominance among developers";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement codePasteArea;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingClick;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationClick;

    @FindBy(id = "postform-name")
    private WebElement nameTitlePasteArea;

    @FindBy(xpath = "//*[@id='w0']/div[5]/div[1]/div[8]/button")
    private WebElement createNewPasteButton;


    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public PastebinHomePage codePaste() {
        codePasteArea.sendKeys(CODE);
        return this;
    }

    public PastebinHomePage setSyntaxHighlighting() {
        syntaxHighlighting.click();
        syntaxHighlightingClick.click();

        return this;
    }

    public PastebinHomePage setPasteExpiration() {
        pasteExpiration.click();
        pasteExpirationClick.click();

        return this;
    }

    public PastebinHomePage setPasteNameTitle() {
        nameTitlePasteArea.sendKeys(PASTE_NAME_TITLE);
        return this;
    }

    public PastebinNewPastePage createNewPaste() {
        createNewPasteButton.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div")));
        return new PastebinNewPastePage(driver);
    }

    public static String getPasteName() {
        return PASTE_NAME_TITLE;
    }

    public static String getCode() {
        return CODE;
    }

    public static String getSyntaxHighlighting() {
        return SYNTAX_HIGHLIGHTING;
    }

}
