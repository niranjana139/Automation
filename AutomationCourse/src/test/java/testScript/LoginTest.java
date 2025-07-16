package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumBasics.TestNgBase;

public class LoginTest extends TestNgBase {
	
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUsernameField();
		loginPage.enterPasswordOnPasswordField();
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidPasswordInvalidUsername() {
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user1");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement loginBtn=driver.findElement(By.id("login-button"));
		loginBtn.click();
	}

	@Test
	public void verifyWhetherUserIsAbleToLoginWithInValidPasswordValidUsername() {
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce1");
		WebElement loginBtn=driver.findElement(By.id("login-button"));
		loginBtn.click();
	}
	
	@Test
	public void verifyWhetherUserIsAbleToLoginWithInValidPasswordInValidUsername() {
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user1");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce1");
		WebElement loginBtn=driver.findElement(By.id("login-button"));
		loginBtn.click();
	}
}
