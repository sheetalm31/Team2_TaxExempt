
	package com.dollardays.testcases;

	import java.io.UnsupportedEncodingException;
	import java.security.GeneralSecurityException;
	import java.util.Hashtable;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
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
	import com.dollardays.testcases.*;

	public class SortandViewTestcases extends BaseTest{
		
		@DDDataProvider(datafile = "testdata/Team3Search and Sort.xlsx", sheetName = "SortandView",  testcaseID = "", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
		public void TC_SortandViewByoptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Sort and view functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Successfully singed in  with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Successfully entered Product name in the search bar");
			
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Successfully clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Successfully clicked on the SortBY dropdown menu");
			
					
			Select sortby = new Select(searchpage.getSortBybutton());
			String sortvalue =datatable.get("SortValue");
		    sortby.selectByVisibleText(sortvalue);
		    ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Successfully clicked on " + datatable.get("SortValue")+ "from the dropdown");
		    
		    Select View = new Select(searchpage.getViewoptions());
		    String viewvalue =datatable.get("ViewValue");
		    View.selectByVisibleText(viewvalue);
		    ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Successfully Clicked on " + datatable.get("ViewValue")+ "from the view dropdown");
		   
		   
		    ExtentTestManager.getTest().log(Status.PASS, "Step 7 : Total No.of items displayed in the current page are: " +searchpage.getPageItemsCount().size());
		    
		   
		  //  Assert.assertEquals(searchpage.getPageItemsCount().size(), Integer.parseInt(datatable.get("ViewValue")),"Total No.of items displayed in first page not equals to the Viewby option selected");
			
		   		   
		 
		     Thread.sleep(500);
				loginPage.getUserDrodown().click();
				Thread.sleep(500);
				loginPage.getLogoutBtn().click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 9  : Successfully Signed out");
				
		}
		
		
		}	
	