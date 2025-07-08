package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown extends Base {
	
	public void verifyDropDown() {
		
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
		Select select = new Select(dropdown);
		
		//select.selectByIndex(3);
		//select.selectByValue("python");
		select.selectByVisibleText("C#");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingDropDown drop = new HandlingDropDown();
		drop.initializeBrowser();
		drop.verifyDropDown();
	}

}
