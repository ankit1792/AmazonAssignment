package com.amazon.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazon.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReport {

	public static ExtentReports report=null;
	public static String extentreportpath="";
	

	//To avoid external initialization
	private ExtentReport() {
		extentreportpath=Constants.EXTENTREPORTPATH;
		report=new ExtentReports(extentreportpath);
		report.loadConfig(new File(Constants.EXTENTCONFIGFILEPATH));
	}

	public static void initialize()
	{
		ExtentReport report=new ExtentReport();
	}

}
