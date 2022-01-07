package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	

		WebDriver driver;

		Actions action = new Actions(driver);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;

		public void chromeBrowserLaunch(String Url) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Url);
		}
		
		public void firefoxLaunch(String Url) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(Url);
		}
		
		public void edgeLaunch(String Url) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(Url);
		}
		

		public void maximize() {
			driver.manage().window().maximize();
		}

		

		public String getTitle() {
			String title = driver.getTitle();
			return title;
		}

		public String getUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public String getText(WebElement element) {
			String text = element.getText();
			return text;
		}

		public String getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			return attribute;
		}

		public void print(String data) {
			System.out.println(data);
		}
		

		public String getwindowid() {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;
		}
			
		public void excelWrite(String path, int rownum, int colnum, String string) throws IOException {

			File file = new File(path);
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("wbsheet");
			Row row = sheet.createRow(rownum);
			Cell cell = row.createCell(colnum);
			cell.setCellValue(string);
			FileOutputStream steam = new FileOutputStream(file);
			wb.write(steam);

		}
		
		public String excelRead(String path, int rownum, int colnum) throws IOException {
			
			File file = new File(path);
			FileInputStream steam = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(steam);
			Sheet sheet = wb.createSheet("wbsheet");
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(colnum);
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;

		}
		
		public void moveback() {
			driver.navigate().back();
		}

		public void moveforward() {
			driver.navigate().forward();
		}

		public void refresh() {
			driver.navigate().refresh();
		}

		public void closewindow() {
			driver.close();

		}
		
		public void closeAllwindow() {
			driver.quit();
		}
		
		public void takeScreenShot(String filePath) throws IOException {
			
			TakesScreenshot t = (TakesScreenshot) driver;
			File dest = new File(filePath);
			File Source = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, dest);		

		}

		public WebElement findElementsById(String name) {
			WebElement element = driver.findElement(By.id(name));
			return element;
		}

		public WebElement findElementsByname(String name) {
			WebElement element = driver.findElement(By.name(name));
			return element;
		}
		
		public WebElement findElementsByXpath(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}

		public void Sendvalue(WebElement element, String name) {
			element.sendKeys(name);
		}
		
		public void click(WebElement element) {
			element.click();
		}
		
		public void rightClick(WebElement element) {
			action.contextClick(element).build().perform();
		}
		
		public void doubleClick(WebElement element) {
			action.doubleClick(element).build().perform();

		}

		public void clickAndHold(WebElement element) {
			action.clickAndHold(element);
			
		}
		
		public void dragAndDrop(WebElement src,WebElement des) {
			action.dragAndDrop(src, des);
			
		}
		
		public void moveToElement(WebElement element) {
			action.moveToElement(element);
			
		}
		
		public void scrolDown(int downHeight) {
				
			je.executeScript("window.scrollBy(0,"+ downHeight+")"," ");
		}
		
		public void scrolUp(int upHeight) {
			
			je.executeScript("window.scrollBy(0,-"+upHeight+")"," ");
		}
		
		public void scrolToElement(WebElement element) {
			
			je.executeScript("arguments[0].scrollIntoView();", element);
		}
		
		
		
		
	}


}
