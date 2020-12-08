package Hardcore.tests;

import Hardcore.pages.CalculatorPage;
import Hardcore.pages.EmailGenerationPage;
import Hardcore.pages.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hardcore {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Проверка стоимости через Email")
    public void checkCorrectValuesVIAEmail() {
        EmailGenerationPage emailGenerationPage = new EmailGenerationPage(driver);
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        CalculatorPage calculatorPage = googleCloudHomePage
                .openPage()
                .inputSearchQuery()
                .pickQueryResult()
                .frameSwitch()
                .setNumberOfInstances()
                .setSeries()
                .setMachineType()
                .setGPUMark()
                .setNumberOfGPU()
                .setGPUType()
                .setLocalSSD()
                .setDatacenterRegion()
                .setCommitedUsage()
                .addToEstimateButtonClick();
        String costEstimate = calculatorPage.getCost();
        calculatorPage.switchToEmailPage();
        new EmailGenerationPage(driver).copyEmail().switchToCalculatorPage();
        calculatorPage.frameSwitch().emailEstimateButtonClick().emailInput().sendEmail().switchToEmailPage();
        new EmailGenerationPage(driver).openEmail();
        Assert.assertTrue(costEstimate.contains(emailGenerationPage.getCostFromEmail()));
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}