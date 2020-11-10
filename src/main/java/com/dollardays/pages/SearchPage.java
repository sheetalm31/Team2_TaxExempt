package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input")
	private WebElement searchBar;
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/div/div/button")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/div/div/button")
	private WebElement searchBtn;

	public WebElement getsearchBtn() {
		return searchBtn;
	}
	
	@FindBy(xpath = "//*[@id='facetrefinements']/aside[1]/div/h3/span[@class='sku-count']")
	private WebElement searchCount;
	public WebElement getsearchCount() {
		return searchCount;
	}
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[2]/div/div[1]/div/div/div[4]/button")
	private WebElement submit;
	public WebElement getsubmit() {
		return submit;
	}
	
	
	//@FindBy(xpath = "//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;
	public WebElement getnoDataFoundMsg() {
		return noDataFoundMsg;
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='select-bar pagination-bar']//a[contains(@class,'page-link')]"))
	private List<WebElement> pageCount;

	public List<WebElement> getPageCount() {
		return pageCount;
		
	}
	
	@FindBy(xpath = "//a[@title='Next Page']")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@FindBy(xpath = "//a[@title='Last Page']")
	private WebElement lastPageBtn;

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}
	
	@FindBy(xpath = "//a[@title='First Page']")
	private WebElement firstPageBtn;

	public WebElement getfirstPageBtn() {
		return firstPageBtn;
	}
	
	@FindBy(xpath = "//li[@class='active page-item']")
	private WebElement lastBtntext;

	public WebElement getLastBtntext() {
		return lastBtntext;
		
		}
	
	@FindBy(xpath= "//*[@id=\"aspnetForm\"]/div[6]/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/select")
	private WebElement sortbybutton;
	
	public WebElement getSortBybutton() {
		return sortbybutton;
	}
	
	@FindBy(xpath= "//*[@id=\"aspnetForm\"]/div[6]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/select")
	//@FindBy(xpath = "//select[@class='formlink']")
	private WebElement sortbyView;
	
	public WebElement getViewoptions() {
		return sortbyView;
	}
	
	
	
	
	@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
  	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	
	
	
	
	public String getSearchWithValue() throws InterruptedException {
		
		String msg=null;
		String result = getnoDataFoundMsg().getText();
		System.out.println("-->"+result);
		
		if(result.contains("No Results Found")) {
			msg = getnoDataFoundMsg().getText();
			
		}else {
			msg = getsearchCount().getText();
		}
		
		return msg;
	}
	
	
	
	
	public void getItemCount() throws InterruptedException {
		getLastPageBtn().click();
		Thread.sleep(1000);
		String valueount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
    	
		for(int i=1;i<Integer.parseInt(valueount);i++) {
		    getNextBtn().click();
			Thread.sleep(1000);
			int itemCount = getPageItemsCount().size();
			System.out.println("Page "+ i + "  contains " + itemCount + " rows");
			 
		    Thread.sleep(1000);
		}
	}
	
	
	
	}
	
	

	

