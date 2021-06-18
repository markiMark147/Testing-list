package logIn;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
/**
 * @author markobarlovic
 */
public class logInLogOut {

    public static WebDriver driver;
    public static String driverPath = "D:\\markiMark\\chromedriver.exe";
    public static String baseUrl = "https://atsqa.org/";
    public static String mail = "mar@mail.com";
    public static String pass = "marmail.com";

    @BeforeTest
    public void BeforeClass() throws InterruptedException {
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
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        System.out.println("Sign Out");
        Thread.sleep(1000);
        driver.quit();

    }

    @Test(priority = 1)
    public void LogInSignOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'My Account')]"))).click();
        System.out.println("My Account");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'create one now')]"))).click();
        System.out.println("create one now");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("i_email"))).sendKeys(mail);
        System.out.println("email");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(pass);
        System.out.println("password");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/p[3]/input"))).click();
        System.out.println("I Agree: Submit");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'My Account')]"))).click();
        System.out.println("My Account");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("i_email"))).sendKeys(mail);
        System.out.println("email");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(pass);
        System.out.println("password");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[3]/input"))).click();
        System.out.println("Log In");
        Thread.sleep(1000);

        String expectedUrl ="https://atsqa.org/account";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url does not match!!!", expectedUrl, actualUrl);
        Thread.sleep(1000);
    }
}

