package base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import testcase.TestCaseFile;

public class ProjectSpecificClass {
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void basemethod() throws IOException{
		Properties props = new Properties();
		props.load(TestCaseFile.class.getClassLoader().getResourceAsStream("pathlocate.properties"));
		
		String path = props.getProperty("D:\\Mobile_Automation\\Test001\\drivers\\");
		System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https:www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
