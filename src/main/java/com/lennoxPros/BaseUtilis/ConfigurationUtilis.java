package com.lennoxPros.BaseUtilis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationUtilis {
	protected Properties props;
	public static String propsFileUrl = System.getProperty("user.dir")
			+ "//src//test//resources//configuration//config.properties";

	public ConfigurationUtilis() {
		File file = new File(propsFileUrl);
		try {
			FileInputStream fo = new FileInputStream(file);
			props = new Properties();
			props.load(fo);
			System.out.println("Property file loaded successfully");
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = props.getProperty("base_url");
		return url;
	}

	public String getBrowser() {
		String chromeBrowser = props.getProperty("browser");
		return chromeBrowser;
	}

	
	public String getChromePath() {
		String chrome = props.getProperty("chromePath");
		return chrome;
	}

	public String getFireFoxPath() {
		String firefoxPath = props.getProperty("firefoxpath");
		return firefoxPath;
	}

	public String getIEPath() {
		String iEPath = props.getProperty("iepath");
		return iEPath;
	}
	public String getUsername() {
		String username=props.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=props.getProperty("password");
		return password;
	}


}
