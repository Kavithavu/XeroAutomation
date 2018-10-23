package com.testing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;



public class ReUsableMethods {

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent=null;
	static WebDriver driver=null;
	static ExtentTest logger=null;

	public static void enterText(WebElement obj, String textVal, String objName) {

		if(obj.isDisplayed()) {
			obj.clear();
			obj.sendKeys(textVal);
			logger.log(Status.PASS, MarkupHelper.createLabel(textVal + " is entered in "+ objName +" field", ExtentColor.GREEN));
		}else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
		}
	}

	public static void clickObj(WebElement obj, String objName) {
		if(obj.isDisplayed()) {
			obj.click();
			logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is clicked", ExtentColor.GREEN));
		}else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
		}
	}

	public static void verifyText(WebElement element,String elementName,String expectedText ) throws IOException
	{
		if (element.isDisplayed())
		{	
			if (element.getText().equals(expectedText))
				logger.log(Status.PASS, MarkupHelper.createLabel( elementName+" is displayed as expected", ExtentColor.GREEN));
			else{
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+"is NOT as expected", ExtentColor.RED));
								String imagePath=takeScreenShot();
								logger.addScreenCaptureFromPath(imagePath);
			}
		}
		else
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" not found", ExtentColor.RED));
		}
	}

	public static void XeroAppPage(String actTitle,String expdata)
	{
		if(actTitle.contains(expdata))
		{
			logger.log(Status.PASS, MarkupHelper.createLabel( "Xero application page is Dispalyed..", ExtentColor.GREEN));
		}
		else
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel( "Xero page did not Displayed..", ExtentColor.RED));	
		}
	}
		public static String takeScreenShot() throws IOException{
			String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String curDir=System.getProperty("user.dir");
			String destination=curDir+"/TestReports/Screenshots/"+reportPath+"image.PNG";
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(destination),true);
			return destination;
		}

	protected static Properties loadPropertyFile(String path) throws IOException {
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(path);
		pro.load(fis);
		return pro;
	}

	
	
	public static void executionReport(String reportName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String timeNow = dtf.format(now);
		timeNow = timeNow.replace(":", "_");
		timeNow = timeNow.replace(" ", "_");
		timeNow = timeNow.replace("/", "_");

		System.out.println(reportName+"_"+timeNow+".html");

		htmlReporter = new ExtentHtmlReporter("C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestReports\\Extent_Reports\\" + reportName+"_"+timeNow+".html");

		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
	}
	
	
	public static void createTestScriptReport(String testScriptName)
	{
		logger = extent.createTest(testScriptName);
	}


	public static void endExtentReport()
	{
		extent.flush();
	}

	public static String[][] readSheet(String FilePath, String sheetName) throws IOException{

		File file=new File(FilePath);
		FileInputStream xfis=new FileInputStream(file);

		HSSFWorkbook workbook=new HSSFWorkbook(xfis);

		/*Step4: Access the Sheet */
		HSSFSheet sheet=workbook.getSheet(sheetName);

		int rows=sheet.getLastRowNum()+1;
		int cols=sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[rows][cols];

		for(int i=1;i<=rows;i++){
			for(int j=0;j<cols;j++){
				if(sheet.getRow(i)==null || sheet.getRow(i).getCell(j) == null) {
					continue;
				}
				HSSFCell cell=sheet.getRow(i).getCell(j);
				if(cell.getCellType()==CellType.STRING)
					xlData[i][j]=cell.getStringCellValue();
				else if(cell.getCellType()==CellType.NUMERIC)
					xlData[i][j]=String.valueOf(cell.getNumericCellValue());
			}
		}

		return xlData;
	}


	public static WebDriver IntializeDriver(String name){
		//System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox53/firefox.exe");
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","./src/test/resources/Utility/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
		}
		else if(name.equalsIgnoreCase("ie")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.ie.driver","./src/test/resources/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}
	
	public static By getLocator(String strElement,Properties propertyFile) throws Exception {

		// retrieve the specified object from the object list

		String locator = propertyFile.getProperty(strElement);

		// extract the locator type and value from the object

		String locatorType = locator.split(":")[0];

		String locatorValue = locator.split(":")[1];

		// for testing and debugging purposes

		System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");


		// return a instance of the By class based on the type of the locator

		// this By can be used by the browser object in the actual test

		if(locatorType.toLowerCase().equals("id"))

			return By.id(locatorValue);

		else if(locatorType.toLowerCase().equals("name"))

			return By.name(locatorValue);

		else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))

			return By.className(locatorValue);

		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))

			return By.className(locatorValue);

		else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))

			return By.linkText(locatorValue);

		else if(locatorType.toLowerCase().equals("partiallinktext"))

			return By.partialLinkText(locatorValue);

		else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))

			return By.cssSelector(locatorValue);

		else if(locatorType.toLowerCase().equals("xpath"))

			return By.xpath(locatorValue);

		else

			throw new Exception("Unknown locator type '" + locatorType + "'");

	}
}
