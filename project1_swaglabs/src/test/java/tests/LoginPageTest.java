package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage login= new LoginPage(driver);
	
	@Test(priority=1)
	public void verifyUrl() {
		
		String acturl=login.verifyUrl();
		String expurl="https://www.saucedemo.com/";

		Assert.assertEquals(acturl, expurl);
		
	}
	
	@Test(priority=2)
	public void verifyTitle()
	{
		String acttitle=login.verifytitle();
		String exptitle="Swag Labs";
		
		Assert.assertEquals(acttitle, exptitle);
	}
	
	
	@Test(priority=3)
	public void login() throws IOException, InterruptedException
	{
		login.verifyloginCredentials();
	}
	
	@Test(priority=4)
	public void errorMsg() throws InterruptedException
	{
		login.invalidUserErrorMessage();
	}
	
	
	@Test(priority=5)
	public void verifyBlankFields() throws InterruptedException
	{
		
		String actmsg = login.blankFields();
		System.out.println(actmsg);
		String expmsg= "Epic sadface: Username is required";
		Assert.assertEquals(actmsg, expmsg);
	}
	
	@Test(priority=6)
	public void verifyValidCredentials() throws InterruptedException
	{
		String actURL= login.validCredentials();
		String expURL="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actURL, expURL);
	}
	
	
	

}
