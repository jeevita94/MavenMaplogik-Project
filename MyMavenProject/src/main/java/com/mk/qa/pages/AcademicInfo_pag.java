package com.mk.qa.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import maplogik_scenario.Base_class;

public class AcademicInfo_pag extends com.mk.qa.base.Base_class {
	
	
	@FindBy(xpath = "//li//a//span[@class='menu-title text-truncate' and contains(text(),'Log out')]")
	public static WebElement studentlogout;
	
	public AcademicInfo_pag() {
		PageFactory.initElements(driver, this);
	}
	

	
public static void studentprofilelogout()
{
	
	studentlogout.click();
}
}