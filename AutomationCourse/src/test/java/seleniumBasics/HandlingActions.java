package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends Base{
	
	public void verifyRightClick() {
		WebElement right= driver.findElement(By.xpath("//a[text()='Home']"));
		Actions act = new Actions(driver);
		//contextClick() used for performing right click. perform() and build() is used for implementing action
		act.contextClick(right).build().perform();
	}
	
	public void verifyMouseHover() {
		WebElement right= driver.findElement(By.xpath("//a[text()='Home']"));
		Actions act =  new Actions(driver);
		act.moveToElement(right).build().perform();
	}
	
	public void verifyDragAndDrop() {
		driver.navigate().to("https://demoqa.com/droppable");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
	}

	public void verifyKeyboardAction() throws AWTException {
		Robot robot = new Robot();
		//VK - Virtual key. keypress simulates key press activity.
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		//keyrelease to release the press of key
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingActions actions =  new HandlingActions();
		actions.initializeBrowser();
		//actions.verifyRightClick();
		//actions.verifyMouseHover();
		//actions.verifyDragAndDrop();
		try {
		actions.verifyKeyboardAction();
		}
		catch(AWTException e) {
			e.printStackTrace();
		}
	}

}
