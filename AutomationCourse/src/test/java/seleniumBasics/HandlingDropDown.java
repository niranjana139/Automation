package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown extends Base {

	public void verifyDropDown() {

		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
		Select select = new Select(dropdown);

		// select.selectByIndex(3);
		// select.selectByValue("python");
		select.selectByVisibleText("C#");
	}

	public void verifyCheckBox() {

		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement checkBox = driver.findElement(By.xpath("//input[@value='option-1']"));
		checkBox.click();
		checkBox.isSelected();
	}
	
	public void verifyRadioButton() {
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement radioButton = driver.findElement(By.xpath("//input[@value=\"green\"]"));
		radioButton.click();
		System.out.println(radioButton.isSelected());
		System.out.println(radioButton.isDisplayed());
		System.out.println(radioButton.isEnabled());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingDropDown drop = new HandlingDropDown();
		drop.initializeBrowser();
		drop.verifyCheckBox();
		//drop.verifyDropDown();
		drop.verifyRadioButton();
	}

}
