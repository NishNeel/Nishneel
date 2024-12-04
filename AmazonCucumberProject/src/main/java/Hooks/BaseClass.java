package Hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class BaseClass {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
			try{
			prop= new Properties();
		    FileInputStream file = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\AmazonCucumberProject\\src\\main\\java\\com\\Properties\\config.properties");
			prop.load(file);
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}
	

	@Before
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
		System.out.println("Chrome driver launched");
		}
		else if(browserName.equals("FireFox")){
			driver = new FirefoxDriver();
			System.out.println("firefox driver launched");
		}
	if (driver != null) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Adjust the timeout as needed
        driver.get(prop.getProperty("url")); // Get URL from properties file
    } else {
        throw new NullPointerException("WebDriver was not initialized properly.");
    }
	}
	
	
	@AfterStep
	public void stepWorking() {
		System.out.println("Step working fine");
	}
	
	@After()
	public void CloseWindow() {
		driver.quit();
	}
	
	public void moveToTheElement(WebElement element) {
		try {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	    } catch (Exception e) {
	        System.out.println("Failed to move to element: " + e.getMessage());
	    }
	}
	
	public WebElement click(WebElement element) {
		 try {
		        element.click();
		    } catch (Exception e) {
		        System.out.println("Failed to click on element: " + e.getMessage());
		    }
		    return element;
}
	}

