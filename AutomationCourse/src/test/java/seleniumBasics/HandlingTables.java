package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingTables extends Base{
	
	public void verifyHandleTables() {
		driver.navigate().to("https://money.rediff.com/indices/nse");
		WebElement table = driver.findElement(By.xpath("//table[@id='dataTable']"));
		System.out.println(table.getText());
		//Fetch a specific row
		WebElement tableRow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[4]"));
		System.out.println(tableRow.getText());
		//Fetch a specific column
		WebElement tableColumn=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[4]/td[2]"));
		System.out.println(tableColumn.getText());
		
		//Fetch last row
		WebElement lastRow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[last()]"));
		System.out.println(lastRow.getText());
		
		//Fetch last column of the 4th row
		WebElement lastColumn = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[4]/td[last()]"));
		System.out.println(lastColumn.getText());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingTables tables = new HandlingTables();
		tables.initializeBrowser();
		tables.verifyHandleTables();
	}

}
