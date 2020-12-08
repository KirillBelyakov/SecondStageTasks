package HurtMePlenty.tests;

import HurtMePlenty.pages.CalculatorPage;
import HurtMePlenty.pages.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlenty {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        calculatorPage = new GoogleCloudHomePage(driver).openPage()
                .clickSearchButton()
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
    }

    @Test(description = "Проверяем данные")
    public void checkCorrectValues() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calculatorPage.getValueOFVMMachine().contains("regular"),
                "Класс виртуальной машины указан верно");
        softAssert.assertTrue(calculatorPage.getValueOFInstanceType().contains("n1-standard-8"),
                "Тип виртуальной машины указан верно");
        softAssert.assertTrue(calculatorPage.getValueRegion().contains("Oregon"),
                "Регион указан верно");
        softAssert.assertTrue(calculatorPage.getValueLocalSSD().contains("2x375"),
                "Значение Local SSD верно");
        softAssert.assertTrue(calculatorPage.getValueOfCommitedTerm().contains("1 year"),
                "Время пользования указано верно");
        softAssert.assertTrue(calculatorPage.getCost().contains("5,413.06"),
                "Цена указана верно");
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
