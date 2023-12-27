package mobileWeatherApp.utils;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {



	AppiumDriver driver ;
	public AppiumDriverLocalService service ;
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int portNumber) {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\mohamed.abdelrahman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress)
				.usingPort(portNumber).build();
		service.start();
		return service;
	}
	
	
	public void waitForMobileElementToAppear(WebElement element, AppiumDriver driver) {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
}
