package TestNGListenersSuiteLevel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;


@Listeners(TestNGListenersClassLevel.TestListener.class)
public class MyFirstTestCase {
	@Test
	public void veriyGoogleTitle() {
		System.out.println("Google verification");
	}
	
	@Test
	public void veriyGoogleSearch() {
		Assert.assertTrue(false);
		System.out.println("Google Search box verification");
	}

}
