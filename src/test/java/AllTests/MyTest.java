package AllTests;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.NewXL;
import POM.HomePage;

public class MyTest extends BaseTest{

	@DataProvider
	public Iterator<Object[]> getdata() throws EncryptedDocumentException, IOException
	{
		ArrayList<Object[]> myd = NewXL.readData2();
		
	
		
		return myd.iterator();
		
	}
	
	
	@Test(dataProvider="getdata")
	public void Take(String Q1,String Q2,String Q3,String Q4) throws InterruptedException
	{
		
		
		init();
		HomePage Hp=new HomePage();
		boolean Flg = Hp.findp(Q1,Q2,Q3,Q4);
		Assert.assertEquals(Flg, true , " Result Not Match");
		System.out.println("hiiii");
	}
	
	@AfterMethod
	public void end()
	{
		driver.close();
	}
	
}
