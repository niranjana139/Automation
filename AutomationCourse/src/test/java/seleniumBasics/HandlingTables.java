package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingTables extends Base{
	
	public void verifyHandleTables() {
		driver.navigate().to("https://money.rediff.com/indices/nse");
		WebElement table = driver.findElement(By.xpath("//table[@id='dataTable']"));
		System.out.println(table.getText());
		//Fetch only rows
		WebElement tableRow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[3]"));
		System.out.println(tableRow.getText());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingTables tables = new HandlingTables();
		tables.initializeBrowser();
		tables.verifyHandleTables();

	}

}
