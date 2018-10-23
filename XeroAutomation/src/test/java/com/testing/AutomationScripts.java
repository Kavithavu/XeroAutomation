package com.testing;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts extends ReUsableMethods{

	public static void ID01A() throws Exception
	{

		try
		{
			createTestScriptReport("ID01A");

			driver=IntializeDriver("firefox");
			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID01A");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				username=data[i][1];
				password=data[i][2];
				expdata=data[i][3];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			String actTitle=driver.getTitle();

			XeroAppPage(actTitle,expdata);

			driver.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID01B() throws Exception
	{
		try {
			createTestScriptReport("ID01B");
			driver=IntializeDriver("firefox");

			String username=null;
			String password=null;
			String url=null;
			String expdata=null;
			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID01B");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				username=data[i][1];
				password=data[i][2];
				expdata=data[i][3];
			}

			driver.get(url);
			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			WebElement errmsg=driver.findElement(getLocator("xero.login.errmsg", objPro));

			String acttxt=errmsg.getText();

			verifyText(errmsg, "Error Msg", expdata);

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID01C() throws IOException
	{
		try {
			createTestScriptReport("ID01C");
			driver=IntializeDriver("firefox");

			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID01B");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				username=data[i][1];
				password=data[i][2];
				expdata=data[i][3];
			}

			driver.get(url);
			//		String actTitle=driver.getTitle();
			//
			//		XeroAppPage(actTitle, expdata);

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			WebElement errmsg=driver.findElement(getLocator("xero.login.errmsg", objPro));


			String acttxt=errmsg.getText();

			verifyText(errmsg, "Error Msg", expdata);

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID01D() throws Exception {

		try {

			createTestScriptReport("ID01D");

			driver=IntializeDriver("firefox");
			String username=null;
			String password=null;
			String url=null;
			String expdata1=null;
			String expdata2=null;
			String expdata3=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID01D");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				username=data[i][1];
				password=data[i][2];
				expdata1=data[i][3];
				expdata2=data[i][4];
				expdata3=data[i][5];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String actTitle=driver.getTitle();


			XeroAppPage(actTitle, expdata1);

			WebElement forgotpwd=driver.findElement(getLocator("xero.login.forgotpwd", objPro));
			forgotpwd.click();

			String pwdpage=driver.getTitle();

			if(pwdpage.contains(expdata2))
			{
				logger.info("Forgot Password Page Is Displayed");
			}
			else
			{
				logger.info("Forgot Password page did not Display");
			}

			WebElement email=driver.findElement(getLocator("xero.login.email", objPro));
			email.sendKeys(username);

			WebElement sendlink=driver.findElement(getLocator("xero.login.sendlink", objPro));
			sendlink.click();

			WebElement msg=driver.findElement(getLocator("xero.login.emsg", objPro));
			String Emsg=msg.getText();

			if(Emsg.contains(expdata3))
			{
				logger.info("Password reset msg is displayed");
			}
			else
			{
				logger.info("Password reset did not dispalyed");
			}

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID02A() throws IOException, InterruptedException
	{
		try {
			createTestScriptReport("ID02A");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String password=null;
			String url=null;
			String expdata1=null;
			String fname=null;
			String lname=null;
			String email=null;
			String phone=null;
			String country=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID02A");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				expdata1=data[i][2];
				fname=data[i][3];
				lname=data[i][4];
				email=data[i][5];
				phone=data[i][6];
				country=data[i][7];

			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String actTitle=driver.getTitle();
			XeroAppPage(actTitle, expdata);

			//		System.out.println("gfdgdfgdgdgdgfdgd");
			Thread.sleep(4000);
			WebElement FreeTrial=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			FreeTrial.click();

			//		System.out.println("dsgsfgsfgfdgdfgdf");
			//		String exptxt="Free Trial";

			String ActTxt=driver.getTitle();
			if(ActTxt.contains(expdata1))
			{
				logger.info("Free Trial PAge is Dispalyed");
			}
			else
			{
				logger.info("Free Trial Page did not Display");
			}

			WebElement FName=driver.findElement(By.xpath("//input[@name='FirstName']"));
			//		FName.sendKeys(fname);
			enterText(FName, fname, "FirstName");

			WebElement LName=driver.findElement(By.xpath("//input[@name='LastName']"));
			//		LName.sendKeys(lname);
			enterText(LName, lname, "LastName");

			WebElement Email=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
			//		Email.sendKeys(email);
			enterText(Email, email, "Email");

			WebElement phNo=driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
			//		phNo.sendKeys(phone);
			enterText(phNo, phone, "PhoneNum");

			WebElement cntry=driver.findElement(By.xpath(" //select[@name='LocationCode']"));
			Select drpdwn=new Select(cntry);
			drpdwn.selectByVisibleText(country);

			WebElement chkbox=driver.findElement(By.xpath("//input[@value='true']"));
			//		chkbox.click();
			clickObj(chkbox, "Chckbox");

			WebElement getStart=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
			//		getStart.click();
			clickObj(getStart, "GetStartedBtn");

			WebElement inboxpage=driver.findElement(By.xpath("//a[text()='Go to inbox']"));
			clickObj(inboxpage, "GoToInbox");

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void ID02B() throws IOException, InterruptedException
	{
		try {
			createTestScriptReport("ID02B");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url=null;
			String expdata1=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";

			String[][] data=readSheet(FilePath, "ID02B");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				expdata1=data[i][2];
			}

			driver.get(url);

			String actTitle=driver.getTitle();
			XeroAppPage(actTitle, expdata);

			Thread.sleep(4000);
			WebElement FreeTrial=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			FreeTrial.click();

			String ActTxt=driver.getTitle();
			if(ActTxt.contains(expdata1))
			{
				logger.info("Free Trial PAge is Dispalyed");
			}
			else
			{
				logger.info("Free Trial Page did not Display");
			}

			WebElement getStart=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
			getStart.click();

			WebElement fname1=driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']"));
			String Fname=fname1.getText();

			if(Fname.contains("First"))
			{
				logger.info("First Name can't be empty error msg is validated");
			}
			else
			{
				logger.info("FIrst name can't be empty  error msg did not validated");
			}

			WebElement lname1=driver.findElement(By.xpath("//span[@id='signup-form-error-message-2']"));
			String Lname=lname1.getText();


			if(Lname.contains("Last"))
			{
				logger.info("Last Name can't be empty error msg is validated");
			}
			else
			{
				logger.info("Last name can't be empty  error msg did not validated");
			}



			WebElement email1=driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
			String Email=email1.getText();
			if(Email.contains("Email"))
			{
				logger.info("Email  can't be empty error msg is validated");
			}
			else
			{
				logger.info("Email  can't be empty  error msg did not validated");
			}

			WebElement phno=driver.findElement(By.xpath("//span[@id='signup-form-error-message-4']"));
			String PhNo=phno.getText();
			if(PhNo.contains("Phone"))
			{
				logger.info("Phone number  can't be empty error msg is validated");
			}
			else
			{
				logger.info("Phone number  can't be empty  error msg did not validated");
			}


			WebElement emailtxtbox=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
			emailtxtbox.sendKeys("vfdggrtger");

			//		WebElement submit=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
			//		submit.click();

			WebElement invlaidemail=driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
			String errmsg=invlaidemail.getText();
			if(errmsg.contains("invalid"))
			{
				logger.info("Email address is invalid, error msg is validated");
			}
			else
			{
				logger.info("Email address is invalid,  error msg did not validated");
			}

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

	public static void ID02C() throws IOException, InterruptedException
	{
		try {

			createTestScriptReport("ID02C");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url=null;
			String expdata1=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			String[][] data=readSheet(FilePath, "ID02C");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				expdata1=data[i][2];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String actTitle=driver.getTitle();
			XeroAppPage(actTitle, expdata);

			Thread.sleep(4000);
			WebElement FreeTrial=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			clickObj(FreeTrial, "Free Trial");

			String ActTxt=driver.getTitle();
			if(ActTxt.contains(expdata1))
			{
				logger.info("Free Trial PAge is Dispalyed");
			}
			else
			{
				logger.info("Free Trial Page did not Display");
			}

			Thread.sleep(4000);
			WebElement freeTrialTxt=driver.findElement(By.xpath("//h2[@class='title title-2']"));
			String text=freeTrialTxt.getText();

			Thread.sleep(4000);
			if(text.contains("30 day"))
			{
				System.out.println("30 day free trial page is displayed and validated");
			}
			else
			{
				System.out.println("30 day free trial page did not diaplyed");
			}

			driver.manage().window().maximize();
			String parentHandle=driver.getWindowHandle();
			//		System.out.println(parentHandle);


			WebElement termsLink=driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
			clickObj(termsLink, "Terms Link");

			Thread.sleep(4000);
			Set handles = driver.getWindowHandles();
			System.out.println(handles);
			// Pass a window handle to the other window
			for (String handle1 : driver.getWindowHandles()) {
				//			System.out.println(handle1);
				driver.switchTo().window(handle1);
			}

			String title=driver.getTitle();
			System.out.println(title);


			if(title.contains("Terms"))
			{
				System.out.println("Terms of use page is displayed and validated");
			}
			else
			{
				System.out.println("Terms of use  page did not diaplyed");
			}

			driver.close();
			driver.switchTo().window(parentHandle);

			Thread.sleep(4000);
			WebElement privacylink=driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
			clickObj(privacylink, "Privacy Notice");

			String newwin=driver.getWindowHandle();
			//		System.out.println(newwin);

			Thread.sleep(4000);
			Set handles1 = driver.getWindowHandles();
			System.out.println(handles1);
			// Pass a window handle to the other window
			for (String handle1 : driver.getWindowHandles()) {
				//			System.out.println(handle1);
				driver.switchTo().window(handle1);
			}

			Thread.sleep(4000);
			String Privacytitle=driver.getTitle();
			//		System.out.println(Privacytitle);
			Thread.sleep(4000);
			if(Privacytitle.contains("Privacy"))
			{
				System.out.println("Privacy and Notice page is displayed and validated");
			}
			else
			{
				System.out.println("Privacy and Notice  page did not diaplyed");
			}

			driver.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID02D() throws IOException, InterruptedException, AWTException
	{
		try
		{
			createTestScriptReport("ID02D");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url=null;
			String expdata1=null;
			String expdata2=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			String[][] data=readSheet(FilePath, "ID02D");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				expdata1=data[i][2];
				expdata2=data[i][3];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String actTitle=driver.getTitle();
			XeroAppPage(actTitle, expdata);

			Thread.sleep(4000);
			WebElement FreeTrial=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			clickObj(FreeTrial, "Free Trial");

			String ActTxt=driver.getTitle();
			if(ActTxt.contains(expdata1))
			{
				logger.info("Free Trial PAge is Dispalyed");
			}
			else
			{
				logger.info("Free Trial Page did not Display");
			}

			Thread.sleep(4000);
			WebElement freeTrialTxt=driver.findElement(By.xpath("//h2[@class='title title-2']"));
			String text=freeTrialTxt.getText();

			Thread.sleep(4000);
			if(text.contains("30 day"))
			{
				System.out.println("30 day free trial page is displayed and validated");
			}
			else
			{
				System.out.println("30 day free trial page did not diaplyed");
			}

			String handle= driver.getWindowHandle();

			System.out.println(handle);

			WebElement offerdtls=driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
			clickObj(offerdtls, "Offer Details"); 


			Set handles = driver.getWindowHandles();
			System.out.println(handles);
			// Pass a window handle to the other window
			for (String handle1 : driver.getWindowHandles()) {
				System.out.println(handle1);
				driver.switchTo().window(handle1);
			}

			Thread.sleep(4000);
			String title=driver.getTitle();
			System.out.println(title);

			Thread.sleep(4000);

			if(title.contains(expdata2))
			{
				System.out.println("Offer detail page is displayed and validated");
			}
			else
			{
				System.out.println("Offer detail page did not diaplyed");
			}
			driver.switchTo().window(handle);

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID02E() throws IOException, InterruptedException
	{
		try {

			createTestScriptReport("ID02E");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url=null;
			String expdata1=null;
			String expdata2=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			String[][] data=readSheet(FilePath, "ID02E");

			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				expdata1=data[i][2];
				expdata2=data[i][3];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String actTitle=driver.getTitle();
			XeroAppPage(actTitle, expdata);

			Thread.sleep(4000);
			WebElement FreeTrial=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			clickObj(FreeTrial, "Free Trial");

			String ActTxt=driver.getTitle();
			if(ActTxt.contains(expdata1))
			{
				logger.info("Free Trial PAge is Dispalyed");
			}
			else
			{
				logger.info("Free Trial Page did not Display");
			}

			Thread.sleep(4000);
			WebElement freeTrialTxt=driver.findElement(By.xpath("//h2[@class='title title-2']"));
			String text=freeTrialTxt.getText();

			Thread.sleep(4000);
			if(text.contains("30 day"))
			{
				System.out.println("30 day free trial page is displayed and validated");
			}
			else
			{
				System.out.println("30 day free trial page did not diaplyed");
			}
			driver.manage().window().maximize();

			WebElement accntnt=driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
			accntnt.click();

			String acntxt=driver.getTitle();
			System.out.println(acntxt);
			if(acntxt.contains(expdata2))
			{
				System.out.println("A new Let's start a great partnership web page  is displayed and validated");
			}
			else
			{
				System.out.println("A new Let's start a great partnership web page did not diaplyed");
			}

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID03A() throws Exception
	{
		try {
			createTestScriptReport("ID03A");

			Thread.sleep(4000);
			driver=IntializeDriver("firefox");
			driver.manage().deleteAllCookies();
			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID03A");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				username=data[i][2];
				password=data[i][3];

			}

			driver.get(url);
			System.out.println(url);

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


			WebElement login=driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
			login.click();

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			String actTitle=driver.getTitle();

			XeroAppPage(actTitle,expdata);


			WebElement txt=driver.findElement(By.xpath("//span[@class='xn-h-demo-bar-text']"));
			String acttxt=txt.getText();
			if(acttxt.contains("You are"))
			{
				System.out.println("You are currently using a trial account page is displayed");
			}
			else
			{
				System.out.println("You are currently using a trial account page did not displayed");
			}

			WebElement dashbrd=driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"));
			dashbrd.click();

			WebElement accnt=driver.findElement(By.xpath("//a[text()='Accounts']"));
			accnt.click();

			Thread.sleep(4000);
			WebElement reports=driver.findElement(By.xpath("//a[text()='Reports']"));
			reports.click();

			Thread.sleep(4000);
			WebElement contacts=driver.findElement(By.xpath("//a[text()='Contacts']"));
			contacts.click();

			Thread.sleep(4000);
			WebElement settings=driver.findElement(By.xpath("//a[text()='Settings']"));
			settings.click();

			WebElement plusTab=driver.findElement(By.xpath("//a[@id='quicklaunchTab']"));
			plusTab.click();

			WebElement files=driver.findElement(By.xpath("//a[@class='files']"));
			files.click();

			WebElement notification=driver.findElement(By.xpath("//a[@class='notifications x-sandbox']"));
			notification.click();

			driver.switchTo().defaultContent();

			WebElement search=driver.findElement(By.xpath("//a[@class='search']"));
			search.click();

			WebElement help=driver.findElement(By.xpath("/a[@class='help']"));
			help.click();

			driver.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void ID04A() throws IOException
	{
		try {
			createTestScriptReport("ID04A");

			Thread.sleep(4000);
			driver=IntializeDriver("firefox");
			driver.manage().deleteAllCookies();
			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID04A");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				username=data[i][2];
				password=data[i][3];

			}

			driver.get(url);
			System.out.println(url);

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


			WebElement login=driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
			login.click();

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			String actTitle=driver.getTitle();

			XeroAppPage(actTitle,expdata);


			WebElement usname=driver.findElement(By.xpath("//a[@class='username']"));
			usname.click();

			WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logout.click();

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID06A() throws IOException, InterruptedException
	{
		try {
			createTestScriptReport("ID06A");

			Thread.sleep(4000);
			driver=IntializeDriver("firefox");
			driver.manage().deleteAllCookies();
			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID06A");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				expdata=data[i][1];
				username=data[i][2];
				password=data[i][3];

			}

			driver.get(url);
			System.out.println(url);

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


			WebElement login=driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
			login.click();

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			//			uname.sendKeys(username);
			enterText(uname, username, "UserName");
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			WebElement usname=driver.findElement(By.xpath("//a[@class='username']"));
			usname.click();

			WebElement profile=driver.findElement(By.xpath("//a[text()='Profile']"));
			profile.click();

			WebElement pfs=driver.findElement(By.xpath("//h1[contains(text(),'Profile Settings')]"));
			String pfpage=pfs.getText();

			if(pfpage.contains("Profile Settings"))
			{
				System.out.println("Profile Settings Page is Opened");
			}
			else
			{
				System.out.println("Profile Settings page did not open");
			}

			Thread.sleep(5000);
			WebElement upimg=driver.findElement(By.xpath("//span[text()='Change Image']"));
			upimg.click();
			//span[@id='button-1043-btnInnerEl']

			Thread.sleep(4000);
			WebElement browse=driver.findElement(By.xpath("//input[@name='file']"));
			browse.sendKeys("C:\\Users\\kavit\\OneDrive\\Pictures\\Saved Pictures\\newflower.jpg");

			Thread.sleep(4000);
			WebElement upload=driver.findElement(By.xpath("//span[text()='Upload']"));
			upload.click();

			driver.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void ID08A() throws IOException, InterruptedException, AWTException
	{
		try {

			createTestScriptReport("ID08A");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url="https://www.xero.com";
			String expdata1=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";

			//		String[][] data=readSheet(FilePath, "ID08A");

			//		for(int i=1;i<data.length;i++)
			//		{
			//			url=data[i][0];
			//			expdata=data[i][1];
			//			expdata1=data[i][2];
			//		}

			driver.get(url);

			String actTitle=driver.getTitle();
			//		XeroAppPage(actTitle, expdata);

			WebElement login=driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
			login.click();

			WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
			//		username.sendKeys("gopala.anumanchipalli@gmail.com");
			enterText(username, "gopala.anumanchipalli@gmail.com", "UserName");

			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			//		password.sendKeys("password12");
			enterText(password, "password12", "Password");

			WebElement loginbtn=driver.findElement(By.xpath("//button[@id='submitButton']"));
			//		loginbtn.click();
			clickObj(loginbtn, "Login Button");

			WebElement zero=driver.findElement(By.xpath("//h2[@class='org-name']"));
			//		zero.click();
			clickObj(zero, "Zero Tab");

			WebElement myXero=driver.findElement(By.xpath("//a[@class='myxero-link']"));
			//		myXero.click();
			clickObj(myXero, "My Xero Tab");

			WebElement addOrg=driver.findElement(By.xpath("//a[@id='ext-gen1043']"));
			//		addOrg.click();
			clickObj(addOrg, "Add Organization");

			Thread.sleep(4000);
			WebElement orgName=driver.findElement(By.xpath("//input[@name='OrganisationName']"));
			enterText(orgName, "self", "Organization Name");

			WebElement country=driver.findElement(By.xpath("//input[@name='CountryCode']"));
			enterText(country, "United States", "Country");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(4000);
			WebElement timeZone=driver.findElement(By.xpath("//input[@name='TimeZone']"));
			enterText(timeZone, "(UTC-08:00) Pacific Time (US & Canada)", "Time Zone");
			timeZone.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);	
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(10000);

			WebElement odo=driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
			//		odo.sendKeys("software");
			enterText(odo, "Software Service", "Organization does");
			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ENTER);
			robot1.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(4000);
			WebElement st=driver.findElement(By.xpath("//a[text()='Start Trial']"));
			//		st.click();
			clickObj(st, "Start Trial");

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID08B() throws InterruptedException, IOException, AWTException
	{
		try {

			createTestScriptReport("ID08B");

			driver=IntializeDriver("firefox");
			String expdata=null;
			String url="https://www.xero.com";
			String expdata1=null;

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";

			//		String[][] data=readSheet(FilePath, "ID08A");

			//		for(int i=1;i<data.length;i++)
			//		{
			//			url=data[i][0];
			//			expdata=data[i][1];
			//			expdata1=data[i][2];
			//		}

			driver.get(url);

			String actTitle=driver.getTitle();
			//		XeroAppPage(actTitle, expdata);

			WebElement login=driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
			login.click();

			WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
			//		username.sendKeys("gopala.anumanchipalli@gmail.com");
			enterText(username, "gopala.anumanchipalli@gmail.com", "UserName");

			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			//		password.sendKeys("password12");
			enterText(password, "password12", "Password");

			WebElement loginbtn=driver.findElement(By.xpath("//button[@id='submitButton']"));
			//		loginbtn.click();
			clickObj(loginbtn, "Login Button");

			WebElement zero=driver.findElement(By.xpath("//h2[@class='org-name']"));
			//		zero.click();
			clickObj(zero, "Zero Tab");

			WebElement myXero=driver.findElement(By.xpath("//a[@class='myxero-link']"));
			//		myXero.click();
			clickObj(myXero, "My Xero Tab");

			WebElement addOrg=driver.findElement(By.xpath("//a[@id='ext-gen1043']"));
			//		addOrg.click();
			clickObj(addOrg, "Add Organization");

			Thread.sleep(4000);
			WebElement orgName=driver.findElement(By.xpath("//input[@name='OrganisationName']"));
			enterText(orgName, "self", "Organization Name");

			WebElement country=driver.findElement(By.xpath("//input[@name='CountryCode']"));
			enterText(country, "United States", "Country");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(4000);
			WebElement timeZone=driver.findElement(By.xpath("//input[@name='TimeZone']"));
			enterText(timeZone, "(UTC-08:00) Pacific Time (US & Canada)", "Time Zone");
			timeZone.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);	
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			WebElement odo=driver.findElement(By.xpath("//input[@name='IndustryFreeText']"));
			//		odo.sendKeys("software");
			enterText(odo, "Accounting Practice", "Organization does");
			//		odo.click();
			//		Robot robot1 = new Robot();
			//		robot1.keyPress(KeyEvent.VK_ENTER);
			//		robot1.keyRelease(KeyEvent.VK_ENTER);


			Thread.sleep(8000);
			WebElement buynow=driver.findElement(By.xpath("//a[text()='Buy Now']"));
			buynow.click();

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ID10A() throws Exception
	{
		try
		{

			createTestScriptReport("ID10A");

			driver=IntializeDriver("firefox");
			String username=null;
			String password=null;
			String url=null;
			String expdata=null;

			String objectRepoPath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\src\\test\\resources\\Utility\\ObjectRepository.Properties";
			Properties objPro=loadPropertyFile(objectRepoPath);

			String FilePath="C:\\Users\\kavit\\git\\XeroAutomation\\XeroAutomation\\TestData\\XeroTestData.xls";
			System.out.println("im here");
			String[][] data=readSheet(FilePath, "ID10A");
			for(int i=1;i<data.length;i++)
			{
				url=data[i][0];
				username=data[i][1];
				password=data[i][2];
				expdata=data[i][3];
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement uname=driver.findElement(getLocator("xero.login.username", objPro));
			uname.sendKeys(username);
			WebElement pwd=driver.findElement(getLocator("xero.login.password", objPro));
			pwd.sendKeys(password);
			WebElement loginbtn=driver.findElement(getLocator("xero.login.loginbutton", objPro));
			loginbtn.click();

			String actTitle=driver.getTitle();

			XeroAppPage(actTitle,expdata);


			WebElement accnt=driver.findElement(By.xpath("//a[text()='Accounts']"));
			accnt.click();

			WebElement purchases=driver.findElement(By.xpath("//a[text()='Purchases']"));
			purchases.click();

			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}














