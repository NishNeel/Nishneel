package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'The email or phone number you’ve entered doesn’t match any account')]")
    private WebElement errorMessage;


    // Constructor to initialize the driver and elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Initialize the PageFactory to initialize the elements marked with @FindBy
        PageFactory.initElements(driver, this);
    }
    
    // Method to perform the login action
    public void login(String email, String password) {
    	emailInput.sendKeys(email);
    	passwordInput.sendKeys(password);
    	loginButton.click();
    }
}
