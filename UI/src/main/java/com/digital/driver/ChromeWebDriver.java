package com.digital.driver;
import com.digital.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class ChromeWebDriver {
	public static WebDriver loadChromeDriver(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// options - об]ект для настройки различных параметров и опций в для драйвера хром
		options.addArguments("--disable-extensions");// отключить расширения

		if ( Boolean.parseBoolean(ConfigReader.getProperty("headless"))){
			options.addArguments("--headless");
		}

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Устанавливается неявное ожидание (implicit wait) для драйвера
		//  если драйвер не сможет найти какой-либо элемент на странице
		// он будет ждать до 15 секунд, прежде чем выдать ошибку
		return driver;
	}


}