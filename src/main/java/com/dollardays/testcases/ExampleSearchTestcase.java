package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;

import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.ExampleSearch;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class ExampleSearchTestcase extends BaseTest{


	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	
  public void TC_04_SortByBestMatch_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		SearchPage searchpage = new SearchPage(driver);
		ExtentTest Obj = ExtentTestManager.getTest();
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 4 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		
		String searchvalue =datatable.get("ProductName");
		searchpage.getSearchBar().sendKeys(searchvalue);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Entered Product name in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		searchpage.getSortBybutton().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
		
		Select sortby = new Select(searchpage.getSortBybutton());
		String sortvalue =datatable.get("SortValue");
	    sortby.selectByVisibleText(sortvalue);
	    ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Best Match option from the dropdown");
	    
	    Select View12 = new Select(searchpage.getViewoptions());
	     View12.selectByVisibleText("12");
	     ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Clicked on 12 from the view dropdown");
	     
	  
	    
	     Select View24 = new Select(searchpage.getViewoptions());
	     View24.selectByVisibleText("24");
	     ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Clicked on 24 from the view dropdow");
	     
	     Select View48 = new Select(searchpage.getViewoptions());
	     View48.selectByVisibleText("48");
	     ExtentTestManager.getTest().log(Status.PASS, "Step 8  : Clicked on 48 from the view dropdow");

	     
	     
		
	     Thread.sleep(500);
			loginPage.getUserDrodown().click();
			Thread.sleep(500);
			loginPage.getLogoutBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 9  : Clicked on LogOut");
			
	}
	
	
	}