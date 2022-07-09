package com.base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Lenovo
 * @Description To maintain all reusable methods
 * @createDate 21/6/2022
 */

public class BaseClass {

	public static final String Value = null;
	public static WebDriver driver;

	/**
	 * 
	 * @param browserType
	 * @Description Used to launch Browser
	 * @createDate 21/6/2022
	 */
	// 1.to launch Browser
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;

		}
	}

	/**
	 * 
	 * @param url
	 * @Description Used to load URL
	 * @createDate 21/6/2022
	 * @return string
	 */
	// 2.to get url
	public WebElement findElementByValue(String url) {
		WebElement findElement = driver.findElement(By.id(url));
		return findElement;
	}

	/**
	 * @Description Used to get page title
	 * @createDate 21/6/2022
	 * @return string
	 * 
	 */

	// 3.to get title
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @Description Used to get current URL
	 * @createDate 21/6/2022
	 * @return string
	 */

	// 4.to get current url
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	/**
	 * 
	 * @return String
	 * @Description Used to window handles
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 5.to handle single window
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	/**
	 * 
	 * @return String
	 * @Description Used to get page source
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 6.to get page source
	public String getPageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;

	}

	/**
	 * 
	 * @Description Used to close window
	 * @crationDate 22/06/22
	 */

	// 7.to close the current window
	public void closeWindow() {
		driver.close();

	}

	/**
	 * @Description Used to close all the windows
	 * @creationDate 22/06/2022
	 * 
	 */

	// 8. to close all windows
	public static void closeAllWindow() {
		driver.quit();

	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @Description Used to send keys as String using WebElement element reference
	 * @creationDate 22/06/2022
	 * 
	 */

	// 9.to type text
	public void sendText(WebElement element, String data) {
		element.sendKeys(data);

	}

	/**
	 * 
	 * @param element
	 * @Description Used to click button using WebElement reference
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 10.to click button
	public void clickButton(WebElement element) {
		element.click();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to perform login function using WebElement reference
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 11.to click submit
	public void submit(WebElement element) {
		element.submit();

	}

	/**
	 * 
	 * @param element
	 * @return Point
	 * @Description Used to get location
	 * @Creation 22/06/2022
	 * 
	 */
	// 12.to get the location of the file

	public Point getLocation(WebElement element) {
		Point location = element.getLocation();
		return location;

	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @return String
	 * @Descrption Used to get attribute through WeBElement reference and String
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 13. to get attribute
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;

	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @Description Used to get attribute using WebElement reference
	 * @creationDate 22/06/2022
	 * 
	 */

	// 14.to get attribute
	public String getAttribute2(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description Used to perform enable using WebElement reference
	 * @CreationDate 2/06/2022
	 */

	// 15. to check it is enabled
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description Used to check whether it is displayed using WebElement reference
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 16.to check it is displayed
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description Used to check whether it is selected using WebElement reference
	 * @creationDate 22/06/2022
	 * 
	 */

	// 17.to check it is selected
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;

	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @Description Used to get text
	 * @CraetionDate 22/06/2022
	 * 
	 */

	// 18.to get the text
	public String getText1(WebElement element) {
		String text = element.getText();
		return text;

	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @Description Used to get the tag name
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 19.to get the tagname
	public String toGetTagName(WebElement element) {
		String tagName = element.getTagName();
		return tagName;

	}

	/**
	 * @param maximize
	 * @Description Used to maximize the window
	 * @CraetionDate 22/06/2022
	 * 
	 */

	// 20. to maximize the window
	public static void maximize() {
		driver.manage().window().maximize();

	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return Point
	 * @Description Used to set point
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 21.to set the point of window
	public Point setPoint(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(new Point(x, y));
		return p;
	}

	/**
	 * 
	 * @param width
	 * @param height
	 * @return Dimension
	 * @Decription Used to set the dimension of window
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 22.to set the dimension of the window
	public Dimension setDimension(int width, int height) {
		Dimension d = new Dimension(width, height);
		return d;
	}

	/**
	 * 
	 * @param element
	 * @Description Used to perform mouse-Hover action
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 23.to perform MouseHover action
	public void performMouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to perform click action
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 24.to perform click action
	public void click(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to perform double click action
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 25.to perform doubleclick
	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to perform right click action
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 26.to perform a right click
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @Description Used to perform drag and drop action
	 * @CraetionDate 22/06/2022
	 * 
	 */

	// 27. to perform a drag and drop

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();

	}

	/**
	 * 
	 * @throws AWTException
	 * @Description Used to perform key press action
	 * @CraetionDate 22/06/2022
	 */

	// 28.to perform key press
	public void keyPress(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);

	}

	/**
	 * 
	 * @throws AWTException
	 * @Description Used to perform key release action
	 * @CraetionDate 22/06/2022
	 */

	// 29.to perform key release
	public void keyRelease(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to type text using Java Script
	 * @CreationDate 22/06/2022
	 */

	// 30. to pass text using javascript
	public void typeJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].('value','" + text + "')", element);

	}

	/**
	 * 
	 * @param element
	 * @Description Used to click button using Java Script
	 * @CraetionDate 22/06/2022
	 * 
	 */

	// 31.to perform click using javascrpit
	public void Button(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click()", element);

	}

	/**
	 * 
	 * @param location
	 * @throws IOException
	 * @Description Used to take Screenshot
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 32.to take screenshot
	public void takeScreeenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(location));
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown by text
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 33.to perform dropdown operation using visibletext
	public void dropDownByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown by value
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 34.to perform dropdown operation using attribute

	public void dropDownByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown by index
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 35.to perform dropdown operation using by index
	public void dropDownByIndex(WebElement element, int s1) {
		Select s = new Select(element);
		s.selectByIndex(s1);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown deselect by visible Text
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 36.to perform dropdown operation using by deselect by visibletext
	public void deselectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown deselect by value
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 37.to perform dropdown operation using by deselect by attribute
	public void deselectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByValue(text);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown deselect by index
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 38.to perform dropdown operation using by deselect by index
	public void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description Used to perform dropdown deselect all
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 39.to perform dropdown operation using by deselectAll
	public void deselectByAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to check the dropdown have multiple elements
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 40.to check multiple option in dropdown
	public void isMultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}

	/**
	 * 
	 * @param url
	 * @Description Used to navigate url
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 41. to navigate to another url
	public void navigateUrl(String url) {
		driver.navigate().to(url);

	}

	/**
	 * @Description Used to navigate forward
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 42.navigate to forward url
	public void navigateForward() {
		driver.navigate().forward();

	}

	/**
	 * @Description Used to navigate backward
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 43.navigate to backward url
	public void navigateBackward() {
		driver.navigate().back();

	}

	/**
	 * @Description Used to navigate refresh
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 44.navigate to refresh url
	public void navigateRefresh() {
		driver.navigate().refresh();

	}

	/**
	 * 
	 * @param time
	 * @throws InterruptedException
	 * @Description Used to stop an execution for a while
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 45.to stop the temporary execution for a while
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);

	}

	/**
	 * 
	 * @param time
	 * @Description Used to perform implicit waits
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 46.to stop the time being execution till executes
	@SuppressWarnings("deprecation")
	public static void implicitWaits(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	/**
	 * 
	 * @param index
	 * @Description Used to switch frame by index
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 47.switch to frame using index
	public void frameIndex(int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * 
	 * @param text
	 * @Description Used to switch frame by value
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 48.switch to frame using frameValue
	public void frameValue(String text) {
		driver.switchTo().frame(text);

	}

	/**
	 * @Description Used to switch to parent frame
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 49.switch to parent frame using frame
	public void frameParent() {
		driver.switchTo().parentFrame();

	}

	/**
	 * 
	 * @param element
	 * @Description Used to switch frame using WebElement reference
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 50.switch to frame using refelement
	public void frameReference(String element) {
		driver.switchTo().frame(element);

	}

	/**
	 * 
	 * @param element
	 * @Description Used to find the locator using id
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 51. to findelement using id
	public WebElement findElementById2(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}

	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @Description Used to find the locator using name
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 52. to findelement using name
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @Description Used to find the locator using class name
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 53. to findelement using className
	public WebElement findElementByclassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;

	}

	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @Description Used to find the locator using tag name
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 54. to findelement using tagName
	public WebElement findElementByTagName(String name) {
		WebElement element = driver.findElement(By.tagName(name));
		return element;

	}

	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @Description Used to find the locator using attribute value
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 55. to findelement using attributeName
	public WebElement xpathValue(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;

	}

	/**
	 * @Description Used to perform simple alerts
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 56. switch to alert click ok
	public void simpleAlerts() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @Description Used to perform confirmed alerts
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 57. switch to alert click ok
	public void confrimAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * 
	 * @param element
	 * @param tagName
	 * @return List<WebElement>
	 * @Description Used to find list of locator using tag name
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 58. to findelements using tagname
	public List<WebElement> findElementsUsingTagName(WebElement element, String tagName) {
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;
	}

	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description Used to find a locator using link text
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 59. to findelement using linkText
	public WebElement findElementByLinkText(String name) {
		WebElement element = driver.findElement(By.linkText(name));
		return element;

	}

	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description Used to find a locator using partial text
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 60.to findelement using PartialLinkText
	public WebElement findElementByPartialLinkText(String name) {
		WebElement element = driver.findElement(By.partialLinkText(name));
		return element;
	}

	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description Used to find a locator using CSSSelector
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 61.to findelement using cssSelector
	public WebElement findElementByCssSelector(String name) {
		WebElement element = driver.findElement(By.cssSelector(name));
		return element;
	}

	/**
	 * 
	 * @param element
	 * @return Object
	 * @Description Used to get the size of the element
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 62.to get the size of element
	public org.openqa.selenium.Dimension getSize(WebElement element) {
		org.openqa.selenium.Dimension size = element.getSize();
		// System.out.println(size.width);
		// System.out.println(size.height);
		return size;
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @Description Used to clear the text
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 63.to clear text
	public void clearText(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * @param url
	 * @Description Used to load url
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 64.loadUrl
	public static void loadUrl(String url) {
		driver.get(url);

	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws IOException
	 * @Description Used to write data in excel
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 65.read data from excel
	public String getData(String sheetName, int rowindex, int cellindex) throws IOException {
		String res = null;
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		CellType celltype = cell.getCellType();
		workbook.close();
		switch (celltype) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date datecellvalue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(datecellvalue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				// BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				long l = (long) numericCellValue;
				res = String.valueOf(l);
			}
			break;

		default:
			break;
		}
		return res;
		
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @Description Used to update data in excel
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 66.update value in excel
	public void upateData(String sheetName, int rowindex, int cellindex, String olddata, String newdata)
			throws IOException {
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		CellType celltype = cell.getCellType();
		String value = cell.getStringCellValue();

		if (value.equals(olddata)) {
			cell.setCellValue(newdata);

		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
		workbook.close();
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException
	 * @Description Used to get data from excel
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 67.insert value in excel
	public void writeData(String sheetName, int rowindex, int cellindex, String data) throws IOException {
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.createCell(cellindex);
		cell.setCellValue(data);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
		workbook.close();
	}

	/**
	 * 
	 * @param string
	 * @return String
	 * @Description Used to get the attribute value
	 * @CreationDate 22/06/2022
	 * 
	 */

	// 68.get AttributeValue
	public String getAttribute(String string) {
		WebElement att = driver.findElement(By.id(string));
		att.getAttribute(Value);
		return null;
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description Used to get the property file value
	 * @CreationDate 25/06/2022
	 */

	// 69.getProperty
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	/**
	 * 
	 * @param element
	 * @Description Used to clear the text
	 * @CreationDate 25/06/2022
	 * 
	 */

	// 70.clearText
	public void clearText2(WebElement element) {
		element.clear();
	}

}
