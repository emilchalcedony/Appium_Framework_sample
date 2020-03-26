package org.amazon.example.utils;

import org.amazon.example.base.Helper;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;

public class Reports_Logs extends Helper {

	public static void InitConfigurations() {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(log4jpath);
		logger = Logger.getLogger(Helper.class);
		report = new ExtentReports(root + "\\ExtentReports\\Report_" + Helper.GetTimeStamp() + ".html");
	
	}
}
