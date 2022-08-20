package com.Vtiger.tests;

import org.testng.annotations.Test;

import com.Vtiger.pages.AccountPage;
import com.Vtiger.pages.LeadPage;
import com.Vtiger.pages.LoginPage;

public class E2E extends BaseTest {
	
	@Test
	public void verify_accountcreation_with_mandatory_fields_TC04()
	{
		String TCname="verify_accountcreation_with_mandatory_fields_TC04";
		logger = extent.createTest(TCname);		
		LoginPage lp = new LoginPage(driver,logger);				
		lp.login(alldata.get(TCname).get("Userid"), alldata.get(TCname).get("password"));
		LeadPage ldp = new LeadPage(driver,logger);
		ldp.clickNewLead();
		ldp.createLeadwithMandatoryFields(alldata.get(TCname).get("lname"), alldata.get(TCname).get("company"));
		ldp.clickNewAccount();
		AccountPage ac = new AccountPage(driver,logger);
		ac.createAccountwithMandatoryFields(alldata.get(TCname).get("AccountName"));
		ac.clickLogout();
		extent.flush();
	}

}
