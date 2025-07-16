package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		//initElements used for initializing elements
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="user-name")WebElement username;
	
	public void enterUserNameOnUsernameField() {
		username.sendKeys("standard_user");
	}
	
	@FindBy(id="password")WebElement password;
	
	
	public void enterPasswordOnPasswordField() {
		password.sendKeys("secret_sauce");
	}
	
	@FindBy(id="login-button")WebElement loginBtn;
	
	public void clickOnLoginButton() {
		loginBtn.click();
	}
	
	
	
	

}
