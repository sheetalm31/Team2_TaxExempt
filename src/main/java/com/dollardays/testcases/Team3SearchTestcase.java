package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;

import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class Team3SearchTestcase extends BaseTest{
	
//////////****************** search for the product with valid data*****************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@DDDataProvider(datafile = "testdata/Team3Search and Sort.xlsx", sheetName = "SearchItem",  testcaseID = "", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)

	public void TC_SearchProductwithValiddata(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		SearchPage searchpage = new SearchPage(driver);
		ExtentTest Obj = ExtentTestManager.getTest();
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Search for the product with valid data");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Successfully singed in  with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		
		String searchvalue =datatable.get("ProductName");
		searchpage.getSearchBar().sendKeys(searchvalue);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Successfully entered " +searchvalue+ "  in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Successfully clicked on the search button");
		Thread.sleep(500);
		
		String result = searchpage.getdisplaysearchresult().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Successfully displayed searched product as: '"+result+"'");
		
		String catcount= searchpage.getcategorycount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Total number of items displayed are: '"+catcount+"'");
		
				
	}


//////////****************** search for the product with Invalid data*****************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

@DDDataProvider(datafile = "testdata/Team3Search and Sort.xlsx", sheetName = "SearchItem",  testcaseID = "", runmode = "No")
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)

public void TC_SearchProductwithInValiddata(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
	SearchPage searchpage = new SearchPage(driver);
	ExtentTest Obj = ExtentTestManager.getTest();
	
	ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Search for the product with Invalid data");
	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Successfully singed in  with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);
	
	String searchvalue =datatable.get("ProductName");
	searchpage.getSearchBar().sendKeys(searchvalue);
	ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Successfully entered " +searchvalue+ "  in the search bar");
	
	searchpage.getsearchBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Successfully clicked on the search button");
	Thread.sleep(500);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step 4  : User entered invalid data: " + searchpage.getnoDataFoundMsg().getText() +  ".");
	
	
			
}


}
	
  