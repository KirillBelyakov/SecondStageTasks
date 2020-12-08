package Hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CalculatorPage extends AbstractPage {

    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_61")
    WebElement numberOfInstances;

    @FindBy(id = "select_value_label_57")
    WebElement seriesSpan;
    @FindBy(xpath = "//*[@id='select_option_186']/div[1]")
    WebElement seriesSpanSelect;

    @FindBy(id = "select_value_label_58")
    WebElement machineTypeSpan;
    @FindBy(css = "md-option[value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8'] div")
    WebElement machineTypeSpanSelect;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement markForAddingGPU;

    @FindBy(id = "select_value_label_390")
    WebElement numberOfGPUSpan;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    WebElement numberOfGPUSelect;

    @FindBy(id = "select_value_label_391")
    WebElement GPUTypeSpan;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement GPUTypeSpanSelect;

    @FindBy(id = "select_value_label_352")
    WebElement localSSDSpan;
    @FindBy(xpath = "//div [contains(text(),'2x375 GB')]")
    WebElement localSSDSpanSelect;

    @FindBy(id = "select_value_label_59")
    WebElement datacenterLocationSpan;
    @FindBy(xpath = "//div[@id='select_container_90']//md-option[@id='select_option_197']")
    WebElement datacenterLocationSpanSelect;


    @FindBy(id = "select_value_label_60")
    WebElement commitedInstanceUsageSpan;
    @FindBy(xpath = "//div[@id='select_container_97']//md-option[@value='1']")
    WebElement commitedInstanceUsageSpanSelect;

    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement addTOEstimateButton;

    @FindBy(id = "email_quote")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[contains(text(),'Send Email')]")
    WebElement sendEmailButton;

    private static final By COST_FROM_ESTIMATE = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");
    private static final By FRAME = By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe");


    public CalculatorPage frameSwitch() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(FRAME));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(numberOfInstances));
        numberOfInstances.sendKeys("4");
        return this;
    }

    public CalculatorPage setSeries() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(seriesSpan));
        executor.executeScript("arguments[0].click()", seriesSpan);
        executor.executeScript("arguments[0].click()", seriesSpanSelect);
        return this;
    }

    public CalculatorPage setMachineType() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(machineTypeSpan));
        executor.executeScript("arguments[0].click()", machineTypeSpan);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(machineTypeSpanSelect));
        executor.executeScript("arguments[0].click()", machineTypeSpanSelect);
        return this;
    }

    public CalculatorPage setGPUMark() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(markForAddingGPU));
        executor.executeScript("arguments[0].click()", markForAddingGPU);
        return this;
    }

    public CalculatorPage setNumberOfGPU() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(numberOfGPUSpan));
        executor.executeScript("arguments[0].click()", numberOfGPUSpan);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(numberOfGPUSelect));
        executor.executeScript("arguments[0].click()", numberOfGPUSelect);
        return this;
    }

    public CalculatorPage setGPUType() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(GPUTypeSpan));
        executor.executeScript("arguments[0].click()", GPUTypeSpan);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(GPUTypeSpanSelect));
        executor.executeScript("arguments[0].click()", GPUTypeSpanSelect);
        return this;
    }

    public CalculatorPage setLocalSSD() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(localSSDSpan));
        executor.executeScript("arguments[0].click()", localSSDSpan);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(localSSDSpanSelect));
        executor.executeScript("arguments[0].click()", localSSDSpanSelect);
        return this;
    }

    public CalculatorPage setDatacenterRegion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(datacenterLocationSpan));
        executor.executeScript("arguments[0].click()", datacenterLocationSpan);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(datacenterLocationSpanSelect));
        executor.executeScript("arguments[0].click()", datacenterLocationSpanSelect);
        return this;
    }

    public CalculatorPage setCommitedUsage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(commitedInstanceUsageSpan));
        executor.executeScript("arguments[0].click()", commitedInstanceUsageSpan);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(commitedInstanceUsageSpanSelect));
        executor.executeScript("arguments[0].click()", commitedInstanceUsageSpanSelect);
        return this;
    }

    public CalculatorPage addToEstimateButtonClick() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addTOEstimateButton));
        executor.executeScript("arguments[0].click()", addTOEstimateButton);
        return this;
    }

    public void switchToEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(" https://10minutemail.com");
    }

    public CalculatorPage emailEstimateButtonClick() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        executor.executeScript("arguments[0].click()", emailEstimateButton);
        return this;
    }

    public CalculatorPage emailInput() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailForm")));
        emailInput.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorPage sendEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        executor.executeScript("arguments[0].click()", sendEmailButton);
        return this;
    }

    public String getCost() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(COST_FROM_ESTIMATE));
        return driver.findElement(COST_FROM_ESTIMATE).getText();
    }
}
