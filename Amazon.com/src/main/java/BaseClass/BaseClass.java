package BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	
public static WebDriver driver;
	
@BeforeMethod
	public void driverIntialization() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    	driver = new ChromeDriver();
		driver.get("https://facebook.com/login.php/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
 @AfterMethod
	public void quit() {
		driver.quit();
	}
    
    public void captureScreenshot(String screenshotName) throws IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenshots/" + screenshotName + ".png");
        FileUtils.copyFile(sourceFile, destinationFile);
    }
    
   
	public void fluentwait(int sec, int pollingSec, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(sec, TimeUnit.MILLISECONDS);
    	wait.pollingEvery(pollingSec, TimeUnit.MILLISECONDS);
    	wait.ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
     public void explicitWait(int sec, WebElement element) {
    	 WebDriverWait wait = new WebDriverWait(driver, sec);
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
     
     public void sendkeys(WebElement element, String text) {
    	 element.sendKeys(text);
     }
     
     public void click(WebElement element) {
    	 element.click();
     }
     
     public void alertGetText() {
    	 Alert alert = driver.switchTo().alert();
         alert.getText();
     }
     public void alaertAccept() {
    	 Alert alert = driver.switchTo().alert();
    	 alert.accept();
     }
     public void alaertDismiss() {
    	 Alert alert = driver.switchTo().alert();
    	 alert.dismiss();
     }
     
     public void switchToFrame(WebElement element) {
    	 driver.switchTo().frame(element);
    	 element.click();
    	 driver.switchTo().defaultContent();
     }
     
     public void actions(WebElement element) {
    	 Actions action = new Actions(driver);
    	 action.moveToElement(element).click().perform();
     }
     
     
}
