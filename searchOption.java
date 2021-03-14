package schedule;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class searchOption {

    public static WebDriver driver;
    public static String driverPath = "D:\\markiMark\\chromedriver.exe";
    public static String url = "https://google.com";

    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"))).sendKeys("4create beograd ");
        System.out.println("Send text for search");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gNO89b"))).click();
        System.out.println("Google search button");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div/div[1]/div/div[1]/a"))).click();
        System.out.println("Click the first result");
        Thread.sleep(2000);
        String expectedUrl = "http://4createsoft.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match!!! ", expectedUrl, actualUrl);
        Thread.sleep(2000);
        String expectedTitle = "4Create - Modernizing healthcare software";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("TITLE does not match!!! ", expectedTitle, actualTitle);
        System.out.println("If Url and Title are correct, close the browser");
        driver.close();
    }

    @Test(priority = 2)
    public void checkEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gb_4"))).click();
        System.out.println("Sign in");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId"))).sendKeys("sender1984test@gmail.com");
        System.out.println("Email");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identifierNext\"]/div/button"))).click();
        System.out.println("Next");
        Thread.sleep(1000);
        //driver.close();
    }
}