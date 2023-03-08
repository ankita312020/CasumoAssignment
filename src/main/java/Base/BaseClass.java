package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static FileInputStream fisReader = null;
	public static Properties property = null;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static HomePage launchBrowser =null;

	@BeforeSuite
	public void initialSetUp() throws IOException {
		fisReader = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		property = new Properties();
		property.load(fisReader);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void setUp(int i) {
		String url = property.getProperty("URI") + "/" + property.getProperty("para" + i + "");
		System.out.println(url);
		driver.get(url);
	}
	
	@BeforeTest
	public void pageFactoryInstance() {
		launchBrowser = PageFactory.initElements(driver, HomePage.class);
	}

	@AfterSuite
	public void closeConnection() {
		driver.quit();
	}

}
