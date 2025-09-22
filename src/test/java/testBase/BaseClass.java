package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties pr;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws MalformedURLException {
		try {
			FileReader file = new FileReader(".//src//test//resources//config.properties");
			pr = new Properties();
			pr.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// To load the logger file and get the all the class we use this.getClass()
		logger = LogManager.getLogger(this.getClass());
		
		//For selenium grid execution
		if (pr.getProperty("executionEnv").equalsIgnoreCase("remote")) {
			DesiredCapabilities capability = new DesiredCapabilities();

			switch (os.toLowerCase()) {
			case "windows":
				capability.setPlatform(Platform.WIN11);
				break;
			case "mac":
				capability.setPlatform(Platform.MAC);
				break;
			default:
				System.out.println("No matching OS");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				capability.setBrowserName("chrome");
				break;
			case "edge":
				capability.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}

		if (pr.getProperty("executionEnv").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid Browser Name...");
				return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(pr.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void teardown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlpaNumeric() {
		return RandomStringUtils.randomAlphanumeric(10);
	}
	
	
	public void setDropDownValue(WebElement ele, String entname)
	{
		Select sc=new Select(ele);
		sc.selectByVisibleText(entname);
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		// String targetFilePath = System.getProperty("user.dir") + File.separator +
		// "screenshots" + File.separator + tname + "_" + timeStamp + ".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
