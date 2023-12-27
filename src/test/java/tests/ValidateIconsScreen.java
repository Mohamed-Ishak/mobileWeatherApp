package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import mobileWeather.screens.HomeScreen;

import mobileWeather.screens.PrivacyPolicyScreen;

import mobileWeatherApp.TestUtils.AndroidBaseTest;

public class ValidateIconsScreen extends AndroidBaseTest{


	PrivacyPolicyScreen policyScreen ;
	HomeScreen homeScreen;

	
	
	@Test
	public void validateThatChanceOfRainingAndHumidityIconsAreDisplayedForNextSixHours(){

		policyScreen = new PrivacyPolicyScreen(driver);
		policyScreen.clickOnGotITButton();
		waitForMobileElementToAppear(policyScreen.weatherAccessDeviceLocation, driver);
		policyScreen.clickOnWhileUsingTheAppButton();
		homeScreen = new HomeScreen(driver);
		Assert.assertEquals(homeScreen.gethoursContainer(),6);
		homeScreen.swipeToLeft();
	
	}
	
}
