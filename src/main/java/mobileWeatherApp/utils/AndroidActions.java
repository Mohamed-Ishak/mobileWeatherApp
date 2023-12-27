package mobileWeatherApp.utils;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{

	AndroidDriver driver ;
	public AndroidActions(AndroidDriver driver) {
		
		this.driver = driver ;
	
	} 
	
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
	      ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
	    "duration",1000));
	}
	
	
	public void scrollToEndAction(String direction) {
		//Second Way when you don't have no prior idea 
		boolean canScrollMore ;
		do {
		  canScrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 100, "height", 100,
			    "direction", direction,
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	
	public void swipeAction(WebElement element,String direction) {
		
		//Swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)element).getId(),
				"direction", direction,
			    "percent", 0.50
			));
	}
	
	public void scrollByGoogleEngin(WebElement element) {
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollInToView(text(\""+element+"\"))"));
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\""+element+"\"))")).click();

	}
	

}
