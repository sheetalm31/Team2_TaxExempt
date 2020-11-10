package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Examle;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class ExamleTestcase extends BaseTest{
	
	   /////**************** TC1: search for item as a Signed in user;  validate category count and  sign out **************////		

	 	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
			@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
			
		    public void TC_01_searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
				SearchPage searchpage = new SearchPage(driver);
				ExtentTest Obj = ExtentTestManager.getTest();
				ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
				LoginPage loginPage = new LoginPage(driver);
				ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
				loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
				Thread.sleep(1000);
				
				String searchvalue =datatable.get("ProductName");
				searchpage.getSearchBar().sendKeys(searchvalue);
				
				ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
				searchpage.getsearchBtn().click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
				Thread.sleep(500);
				
				String categoryCount = searchpage.getsearchCount().getText();
				ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
				
				Thread.sleep(500);
				loginPage.getUserDrodown().click();
				Thread.sleep(500);
				loginPage.getLogoutBtn().click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
			
			} 
			
		////************TC2: search for Item as a Guest User, validating catogory count ****************************////
		
			
	  	public void TC_02_SearchAsaGuestUser() {
		SearchPage searchpage = new SearchPage(driver);
			//ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : Verify Search functionality");
					
			
			searchpage.getSearchBar().sendKeys("Search Backpack");
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
			
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : clicked on the search button");
		
			
			String categoryCount = searchpage.getsearchCount().getText();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Should display '"+categoryCount+"'");
			
		}	
		
		/////***********TC3:No Item Found Error ***************************************////
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	    public void TC_03_NoItemFound(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			String NoItemDisplayed = searchpage.getnoDataFoundMsg().getText();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+NoItemDisplayed+"'");
			
			Thread.sleep(500);
			loginPage.getUserDrodown().click();
			Thread.sleep(500);
			loginPage.getLogoutBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
			
		} 
				
		///////*******************SortBy"BestMatch", View "12,24,48"**********************//////
		
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
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter Product name in the search bar");
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
		
		
		
		
	///////*******************SortBy"Newest First", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC2", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	  public void TC_05_SortByNewestFirst_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
			String sortvalue =datatable.get("SortValue");
		    sortby.selectByVisibleText(sortvalue);
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Newest First option from the dropdown");
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
		
		
			
	///////*******************SortBy"Popularity", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	public void TC_06_SortByPopularity_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
		     sortby.selectByVisibleText("Popularity");
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Popularity option from the dropdown");
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
		
		
		
	///////*******************SortBy"Case Quantity", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	public void TC_07_SortByCaseQuantity_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
		     sortby.selectByVisibleText("Case Quantity");
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Case Qunatity option from the dropdown");
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
		
		
		
		
	///////*******************SortBy"PriceperUnit(LowtoHigh)", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	public void TC_08_SortByPriceperUnitLowtoHigh_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
		     sortby.selectByVisibleText("Price per Unit (Low to high)");
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Price per Unit (Low to high) option from the dropdown");
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
		
			
		
	///////*******************SortBy"PriceperUnit(High to Low)", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	public void TC_09_SortByPriceperUnitHightoLow_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
		     sortby.selectByVisibleText("Price per Unit (High to low)");
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Price per Unit (High to low) option from the dropdown");
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
		
		
		
	///////*******************SortBy"AlphabeticallybyName", View "12,24,48"**********************//////
		
		
		@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		
	public void TC_10_AlphabeticallyByName_ViewOptions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			SearchPage searchpage = new SearchPage(driver);
			ExtentTest Obj = ExtentTestManager.getTest();
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 5 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
			
			String searchvalue =datatable.get("ProductName");
			searchpage.getSearchBar().sendKeys(searchvalue);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
			searchpage.getsearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			searchpage.getSortBybutton().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on the SortBY dropdown");
			Select sortby = new Select(searchpage.getSortBybutton());
		     sortby.selectByVisibleText("Alphabetically by Name");
		     ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on Alphabetically by Name option from the dropdown");
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
		
		
		

