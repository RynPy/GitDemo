package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	

public static WebDriver driver;

public static Properties Config = new Properties();
public static Properties OR = new Properties();
public static FileInputStream fis;
public static Logger log = Logger.getLogger("devpinoylogger")


@SuppressWarnings("deprecation")
@BeforeSuite
public void setUp() {
	
	if(driver==null) {
		
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Config.getProperty("Browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			

		}else if (Config.getProperty("Browser").equals("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			
	}else if (Config.getProperty("Browser").equals("IE")) {
	
	        System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEdriverServer.exe");
	        driver = new InternetExplorerDriver();
	        
	        driver.get(Config.getProperty("testsiteURL"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
}
}
		

/*
 * @AfterSuite public void tearDown() {
 * 
 * if(driver!=null) { driver.quit(); }
 * 
 * }
 */

//}






}

