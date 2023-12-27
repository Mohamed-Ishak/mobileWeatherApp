package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobileWeather.screens.HomeScreen;
import mobileWeather.screens.LandingScreen;
import mobileWeather.screens.PrivacyPolicyScreen;
import mobileWeather.screens.SettingsScreen;
import mobileWeatherApp.TestUtils.AndroidBaseTest;

public class HomeTestScreen extends AndroidBaseTest{

	LandingScreen landingScreen;
	PrivacyPolicyScreen policyScreen ;
	HomeScreen homeScreen;
	SettingsScreen settingsScreen ;
	SimpleDateFormat dateFormat ;
	
	@Test
	public void checkTempratureChangeFromFehrenhiteToCelsius() throws ParseException {

		
		policyScreen = new PrivacyPolicyScreen(driver);
		policyScreen.clickOnGotITButton();
		
		waitForMobileElementToAppear(policyScreen.weatherAccessDeviceLocation, driver);
		policyScreen.clickOnWhileUsingTheAppButton();
		
		homeScreen = new HomeScreen(driver);
		homeScreen.clickingSettingButton();
		
		settingsScreen = new SettingsScreen(driver);
		settingsScreen.clickingOnUnitSettingButton();
		settingsScreen.clickingOnTempDropDown();
		settingsScreen.clickingOnCelsiusOption();	
		settingsScreen.clickingOnTimeFormatDropDown();
		settingsScreen.clickingOnTwentyFourTimeFormatOption();
		
		
		landingScreen = new LandingScreen(driver);
		landingScreen.clickingDoneButton();
		
		Assert.assertTrue(homeScreen.checkThatCelsiusSignIsDisplayed());
		
		
		dateFormat = new SimpleDateFormat("HH:mm");
		String currentDate = dateFormat.format(new Date());
		//date = dateFormat.parse(currentDate);
		System.out.println(currentDate);
		System.out.println(homeScreen.getCurrentDisplayedTime());
		Assert.assertEquals(currentDate, homeScreen.getCurrentDisplayedTime());
		
		
	}
	

	
	
}
