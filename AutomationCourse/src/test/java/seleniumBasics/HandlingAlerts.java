package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingAlerts extends Base {
	
	public void verifySimpleAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alertBtn.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void verifyConfirmAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirmAlertBtn.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}

	public void promptAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement promptAlert = driver.findElement(By.id("promtButton"));
		promptAlert.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Niranjana");
		alert.accept();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingAlerts alerts = new HandlingAlerts();
		alerts.initializeBrowser();
		alerts.promptAlert();
		//alerts.verifySimpleAlert();
		//alerts.verifyConfirmAlert();
	}

}
