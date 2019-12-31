package POM;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//h3[contains(text(),'Find your')][1]")
	WebElement findmatch;
	
	@FindBy(xpath = "//h3[contains(text(),'Find your')][1]")
	WebElement Q1;
	
	@FindBy(xpath = "//h3[contains(text(),'Find your')][1]")
	WebElement Q2;
	
	@FindBy(xpath = "//h3[contains(text(),'Find your')][1]")
	WebElement Q3;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void perfor(String xp1)
	{
		WebElement w1=driver.findElement(By.xpath(xp1));
WebDriverWait wt = new WebDriverWait(driver,5);
wt.until(ExpectedConditions.invisibilityOf(w1));
		System.out.println(xp1);
		System.out.println(w1.getText());
				Actions a=new Actions(driver);
				a.moveToElement(w1).click().perform();
				System.out.println(w1.getText() + " click from mouse");
	}
	
	public boolean findp(String one,String two,String three,String Q4) throws InterruptedException
	{
		Thread.sleep(2000);
		scrol(findmatch);
		driver.findElement(By.xpath("//a[@class='first_cate'][contains(text(),'"+ one +"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'"+ two +"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'"+ three +"')]")).click();
		
		
		
		
	
		
		
/*		
		String xp1="//a[@class='first_cate'][contains(.,'"+one+"')]";
		Thread.sleep(2000);
	
		WebElement btn = driver.findElement(By.xpath(xp1));
		scrol(findmatch);
		//System.out.println(btn.getTagName());
		btn.click();
		//perfor(xp1);
		//WebElement w1=driver.findElement(By.xpath(xp1));
		//Actions a=new Actions(driver);
		//a.moveToElement(w1).click().perform();

		Thread.sleep(1000);
		System.out.println(one + " clicked");
		
		//String two="Party";
		String xp2="//a[contains(text(),'"+two+"')]";
		driver.findElement(By.xpath(xp2)).click();
		//perfor(xp2);
		
		Thread.sleep(2000);
		System.out.println(two + "clicked");
		
		//String three="Musk";
		String xp3="//a[contains(text(),'"+three+"')]";
		driver.findElement(By.xpath(xp3)).click();
		//perfor(xp3);
		Thread.sleep(2000);
		System.out.println(three + "clicked");
		*/
		
		 List<WebElement> res = driver.findElements(By.xpath("//div[@class='simmiler_products_list_third']//h5"));
		
		for (WebElement web : res) {
			String ress=web.getText();
			System.out.println(ress);
			if(ress.equalsIgnoreCase(Q4))
			{
				return true;
				//System.out.println(ress + " same as " + Q4  +" Pass");
			}
			else
			{
				System.out.println("On site --" + ress);
				System.out.println("in excel --" + Q4);
				System.out.println(ress + " Not same as " + Q4  +" Fail");
				//return false;
				
			}
			//System.out.println(res);
		}
			
		return false;
		 
	
	}
	
}
