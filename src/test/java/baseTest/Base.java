package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import boseTest.seleniumTest.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
			public WebDriver driver;
			public LandingPage lp;
			public String id="";
		
			public WebDriver startTest() throws IOException {
				
			Properties p=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalData\\data.properties");
			p.load(fis);
				
			String s=System.getProperty("browser")!=null ?System.getProperty("browser"):p.getProperty("browser");
		
			
			if(s.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(s.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				}
			else if(s.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Rupjit\\eclipse-workspace\\edgedriver_win64\\msedgedriver.exe");
				 driver = new EdgeDriver();
				}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;
	}
			public String takeScreenShot(String tcname,WebDriver driver) throws IOException {
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\reports\\"+tcname+".png"));
				return System.getProperty("user.dir")+"\\reports\\"+tcname+".png";
			}
			
			
			public List<HashMap<Object, Object>> getJsonToHashMap(String s) throws IOException {
				//Read Json as String
				String jstring=FileUtils.readFileToString(new File(s), StandardCharsets.UTF_8) ;
			//Convert String to HashMap
				ObjectMapper mapper=new ObjectMapper();
				List<HashMap<Object,Object>> data=mapper.readValue(jstring, new TypeReference<List<HashMap<Object,Object>>>(){});
			return data;
			}
			public static String decode(String s) {
				byte[] decoding=Base64.decodeBase64(s.getBytes());
				//System.out.println(new String(decoding));
				return new String(decoding);	
			}
			
			@BeforeMethod(alwaysRun=true)
			public LandingPage launchApplication() throws IOException {
				driver=startTest();
				lp=new LandingPage(driver);
				lp.goTo();
				return lp;
			}
			@AfterMethod(alwaysRun=true)
			public void closeWindow() {
				driver.quit();
			}
}
