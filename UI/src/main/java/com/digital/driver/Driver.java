package com.digital.driver;
import com.digital.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {
	private Driver(){
    // Singleton pattern
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver==null){
			switch (ConfigReader.getProperty("browser").toLowerCase()){
				case "chrome":
					driver = ChromeWebDriver.loadChromeDriver();
					break;
				case "firefox":
					driver = FirefoxWebDriver.loadFromFireFox();
					break;
				default:
					throw new IllegalArgumentException("you provided wrong driver name");

			}
		}
		return driver;
	}


	public static void closeDriver(){
		try{
			if (driver!=null){
				driver.close();
				driver.quit();
				driver=null;
			}
		} catch (Exception e) {
			System.out.println("Error while closing the driver: " + e.getMessage());
		}
	}


}
