package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "../Products/exes/chromedriver78.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		driver.get("http://qc.evolutionco.in/ROX/eng");
	}
	
	public static void scrol(WebElement ele)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0, 250)", "");
	js.executeScript("arguments[0].scrollIntoView(true);",ele);
	System.out.println("scrolled");
	//System.out.println(ele.getTagName());
	}
	
}
