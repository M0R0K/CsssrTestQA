package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    public ChromeDriver driver;

    @When("^user launch browser$")  // запуск браузера
    public void userLaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Then("^user go to \"([^\"]*)\"$") // переход на нужный url
    public void userGoTo(String url) {
        driver.get(url);
    }

    @Then("^user click link \"([^\"]*)\"$") // Переход по ссылке
    public void userClickLink(String href) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement link = driver.findElementByXPath("//*[contains(text(),'" + href + "')]");
        link.click();
    }

    @Then("^check current link \"([^\"]*)\"$") // Проверка ссылки на соответствие
    public void checkCurrentLink(String correctUrl) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1)); // Cмена WindowHandle на последний открытый
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(correctUrl, currentUrl);
    }

}