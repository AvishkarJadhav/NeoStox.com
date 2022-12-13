package com.neoStox.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties Pro;
	
	public ReadConfig()
	{
		File src =new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			Pro = new Properties();
			Pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String URL = Pro.getProperty("BaseURL");
		return URL;
	}
	
	public String getMoNo()
	{
		String MobNo = Pro.getProperty("MoNo");
		return MobNo;
	}
	
	public String getPass()
	{
		String PassW = Pro.getProperty("Pass");
		return PassW;
	}
	
	public String getChromeDriver()
	{
		String Driver = Pro.getProperty("ChromePath");
		return Driver;
	}

	public String getFirstName()
	{
		String Firstname = Pro.getProperty("FirstName");
		return Firstname;
	}
	public String getLastName()
	{
		String Lastname = Pro.getProperty("LastName");
		return Lastname;
	}
	public String getUsername()
	{
		String Username = Pro.getProperty("Username");
		return Username;
	}
	
}
