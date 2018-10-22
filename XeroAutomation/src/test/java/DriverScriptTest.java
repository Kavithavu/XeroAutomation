

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DriverScriptTest extends AutomationScripts{

	@Test
	public static void mainMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		String dt_Path="C:\\Kavitha\\Udemy_Workspace\\JavaQaTraining\\XeroAutomation\\src\\test\\resources\\Utility\\XeroTestSuite.xls";
		String[][] recdata=ReUsableMethods.readSheet(dt_Path,"Sheet1");
		String testcase=null;
		String flag=null;
		executionReport("Sprint1");
		for(int i=1;i<recdata.length;i++)
		{
				flag=recdata[i][2];
				
				if(flag.equalsIgnoreCase("Y"))
				{
					testcase=recdata[i][1];
					System.out.println(testcase);
					/*Java reflection*/
					Method testScripts=AutomationScripts.class.getMethod(testcase);
					testScripts.invoke(testScripts);
				}
				else
				{
					System.out.println("Row Number " + i + " test case name " + recdata[i][1]+ " is not executed");
				}
		}

		extent.flush();
	}
	

	public static void closeDriver(){
		driver.close();
	}


}
