package stepDefination;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hooks.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;

public class LoginPage extends BaseClass {
	
	public static Properties prop;


	@FindBy(xpath="//input[@id='email']")
	public WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='pass']")
	public WebElement Password;
	
	
	@FindBy(xpath="//button[@id='u_0_b_Mz']")
	public WebElement login;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver.get("www.facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
	   // throw new io.cucumber.java.PendingException();
	}
	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() {
		mobileNumber.sendKeys(prop.getProperty("mobileNumber"));
		Password.sendKeys(prop.getProperty("password"));
		login.click();
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("user should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
	    System.out.println(driver.getTitle());
	   // throw new io.cucumber.java.PendingException();
	}

	
	
}
