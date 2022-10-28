package com.mk.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.bouncycastle.util.Properties;
//import org.etsi.uri.x01903.v13.QualifyingPropertiesReferenceType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.STPageSetupOrientation;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mk.qa.ExtentReportListeneer.ExtentReporterNG;
import com.mk.qa.base.Base_class;
import com.mk.qa.pages.CollegeActivation_page;
import com.mk.qa.pages.Form_fill;
import com.mk.qa.pages.Home_page;
import com.mk.qa.pages.Login_page;

import net.bytebuddy.implementation.bind.annotation.Super;


public class testcase extends Base_class {
	
	
	Login_page login;
	Home_page homepage;
	CollegeActivation_page col_activate;
	Form_fill fillform;
	Alert alert;
	
	
	@BeforeMethod
	public void setup() throws IOException, AWTException
	{
		
		initialisation();//driver initialisation
		url();
		login=new Login_page();
		login.userids();//udernamepassword
		
	}

	@Test(priority = 1)
	
public void  collegelinkclicking() throws IOException, AWTException, InterruptedException
{
	
	homepage= new Home_page();
	homepage.clickoncollegeactivationlink(); 
	col_activate=new CollegeActivation_page();
	Thread.sleep(5000);
	col_activate.clickonaddnew();
	fillform= new Form_fill();
	fillform.collegename();
	Thread.sleep(5000);
}

@Test(priority = 2)
public void validations()
{
	homepage= new Home_page();
	col_activate=new CollegeActivation_page();
	homepage.clickoncollegeactivationlink();
	

	boolean logopic=col_activate.validatelogo();
	Assert.assertEquals(logopic, true);
	
	
	boolean collegenametitle=col_activate.validatecollegename();
	Assert.assertEquals(collegenametitle, true);
	
	
	boolean collegelocation=col_activate.validatelocation();
	Assert.assertEquals(collegelocation, true);
	

	boolean deleteicon=col_activate.validatedeleteicon();
	Assert.assertEquals(deleteicon, true);
	

	boolean studenticon=col_activate.validateimportstudenticon();
	Assert.assertEquals(studenticon, true);
	
	
	boolean marksicon=col_activate.validateimportstudentmarksicon();
	Assert.assertEquals(marksicon, true);
}

@Test(dependsOnMethods = {"validations"})
public void delete()
{
	
	col_activate=new CollegeActivation_page();
	homepage= new Home_page();
	homepage.clickoncollegeactivationlink();
	col_activate.deletecollege();
	col_activate.alert();
}




@AfterMethod
public void result() throws IOException {
	
	
	homepage.applogout();
	driver.quit();
	
}







}