package ICanWin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinNewPastePage {
    private WebDriver driver;

    public PastebinNewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkOfSuccessfulNewPasteCreation() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div")));
        return (driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div")).size() > 0);

    }
}
