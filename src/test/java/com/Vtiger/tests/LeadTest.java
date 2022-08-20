package com.Vtiger.tests;

import org.testng.annotations.Test;

import com.Vtiger.pages.LeadPage;
import com.Vtiger.pages.LoginPage;

public class LeadTest extends BaseTest {
	
	@Test
	public void verify_leadcreation_with_mandatory_fields_TC03()
	{
		String TCname="verify_leadcreation_with_mandatory_fields_TC03";
		logger = extent.createTest(TCname);		
		LoginPage lp = new LoginPage(driver,logger);				
		lp.login(alldata.get(TCname).get("Userid"), alldata.get(TCname).get("password"));
		LeadPage ldp = new LeadPage(driver,logger);
		ldp.clickNewLead();
		ldp.createLeadwithMandatoryFields(alldata.get(TCname).get("lname"), alldata.get(TCname).get("company"));
		ldp.clickLogout();
		extent.flush();
	}

}
