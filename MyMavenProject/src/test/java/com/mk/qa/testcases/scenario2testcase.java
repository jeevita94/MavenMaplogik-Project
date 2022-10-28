package com.mk.qa.testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mk.qa.base.Base_class;
import com.mk.qa.pages.AcademicInfo_pag;
import com.mk.qa.pages.CollegeActivation_page;
import com.mk.qa.pages.Home_page;
import com.mk.qa.pages.Importmarks_page;
import com.mk.qa.pages.Login_page;
import com.mk.qa.pages.StudentHome_page;
import com.mk.qa.pages.StudentLogin_page;
import com.mk.qa.util.Test_Util;


public class scenario2testcase extends Base_class{
	
	Login_page login;
	StudentLogin_page stdloginpage;
	StudentHome_page stdhmpage;
	AcademicInfo_pag acadmicinfo;
	Home_page adminhomepage;
	CollegeActivation_page admincolactivation;
	Importmarks_page importstudmark;
	Test_Util testutil;
	
		@BeforeMethod
		public  void setup()
		{
			initialisation();
		}
	@Test(priority = 1)
	public void beforeupdatestudentmarks() throws IOException, InterruptedException {
		
		
		Studenturl();
		stdloginpage=new StudentLogin_page();
		stdloginpage.userids();
		stdhmpage=new StudentHome_page();
		stdhmpage.clickonacademiclink();
		//beforescreenshot();
		Test_Util.beforescreenshot();
		acadmicinfo= new AcademicInfo_pag();
		AcademicInfo_pag.studentprofilelogout();
		//driver.quit();
		}

	@Test(priority = 2)
	public void adminupdatestudentmarks() throws IOException, AWTException, InterruptedException
	{
		
		//initialisation();//driver initialisation
		url();
		login=new Login_page();
		login.userids();//udernamepassword
		adminhomepage= new Home_page();
		adminhomepage.clickoncollegeactivationlink();
		admincolactivation= new CollegeActivation_page();
		
		admincolactivation.importmarks();
		importstudmark= new Importmarks_page();
		importstudmark.type();
		importstudmark.course();
		importstudmark.semester();
		importstudmark.upload();
		adminhomepage.applogout();
		//driver.quit();
	}
	@Test(priority = 3,dependsOnMethods ={"adminupdatestudentmarks" })
	public void afterstudentmarksupdate() throws IOException, InterruptedException
	{
	
		//initialisation();
		Studenturl();
		stdloginpage=new StudentLogin_page();
		StudentLogin_page.useridsecondlogin();
		stdhmpage=new StudentHome_page();
		stdhmpage.clickonacademiclink();
		Test_Util.Afterscreenshot();
		//screendhot of updated
		acadmicinfo= new AcademicInfo_pag();
		AcademicInfo_pag.studentprofilelogout();
	
	}
	@AfterMethod
	public void result() throws IOException {
		
		driver.quit();
		
	}
	
}
	
	
	


