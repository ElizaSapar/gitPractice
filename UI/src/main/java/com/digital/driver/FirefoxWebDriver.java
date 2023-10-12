package com.digital.driver;

import com.digital.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxWebDriver {
	public static WebDriver loadFromFireFox(){
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		WebDriver driver = new FirefoxDriver();
		options.addArguments("--disable-extensions");// отключить расширения
		if ( Boolean.parseBoolean(ConfigReader.getProperty("headless"))){
			options.addArguments("--headless");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;

	}
}
