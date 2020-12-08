package BringItOn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinNewPastePage {
    private WebDriver driver;


    private By syntaxHighlightingOfNewPaste = By.xpath("//a[text()='Bash']");
    private By titleOfNewPaste = By.xpath("//h1");
    private By codeFromNewPaste = By.xpath("//*[@class='textarea']");

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement code;

    public PastebinNewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextFromSyntaxHighlightButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(syntaxHighlightingOfNewPaste));
        return syntaxHighlighting.getText();
    }

    public String getTitle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(titleOfNewPaste));
        return title.getText();
    }

    public String getCode() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(codeFromNewPaste));
        return code.getText();
    }

}
