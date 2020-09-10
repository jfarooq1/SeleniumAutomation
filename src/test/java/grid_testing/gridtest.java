package grid_testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gridtest {

	public WebDriver driver;
	DesiredCapabilities dc = new DesiredCapabilities();

	@Parameters({ "browser" })
	@Test
	public void remote_test(String browser) throws MalformedURLException {

		if (browser.equals("chrome")) {
			System.out.println("Inside Chrome...");
			dc.setPlatform(Platform.ANY);
			dc.setBrowserName("chrome");
			ChromeOptions options1 = new ChromeOptions();
			options1.merge(dc);
		}

		else if (browser.equals("firefox")) {
			System.out.println("Inside Firefox...");
			dc.setPlatform(Platform.ANY);
			dc.setBrowserName("firefox");
			FirefoxOptions options = new FirefoxOptions();
			options.merge(dc);
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		driver.get("https://www.google.com/maps");
		

		System.out.println("Thats all of it");
	}

}
