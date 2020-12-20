package com.lennoxPros.BaseUtilis;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage extends ReadExcel {
	
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ConfigurationUtilis config = new ConfigurationUtilis();
	public String baseUrl = config.getApplicationUrl();
	public String browser = config.getBrowser();
	public String chromepath = config.getChromePath();
	public String firefoxpath = config.getFireFoxPath();
	public String iePath = config.getIEPath();
	
	public String user = config.getUsername();
	public String pass = config.getPassword();
	public static Logger log;
	public WebDriver wbdriver=null;
	
	
	
	
	
	@BeforeClass 
	public void setUp() {
		// TODO Auto-generated constructor stub
	
		if(driver.get()==null){
			if(browser.equals("chrome")){
				WebDriverManager.chromedriver().setup();
				wbdriver=new ChromeDriver();
				driver.set(wbdriver);
				
			}
			
		}
		driver.get().manage().window().maximize();
		driver.get().manage().deleteAllCookies();
		driver.get().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get().get("baseUrl");
	}
	
	public void tear_Down()
	{
		driver.get().quit();
	}
	public String getPageTitle() {
		return driver.get().getTitle();
	}
	public void mouseMoveAction(WebElement target) {
		Actions ac=new Actions(driver.get());
		ac.moveToElement(target).click();
		
	}
	public void windowHandling(WebElement element) {
		String current_Window=driver.get().getWindowHandle();
		Set<String> window=driver.get().getWindowHandles();
		for(String win:window) {
			driver.get().switchTo().window(win);
			element.click();
			
		}
	}
	
	public void captureScreenShot( String image) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/screenshots/" + image + ".png");
		FileUtils.copyFile(source, dest);
		log.info("Screenshot was taken");
	}

}
