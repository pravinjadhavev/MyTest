package Base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class NewXL {
	
		static String newSheet=null;
		static String path=null;
		public static Workbook wb;
		
	// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel 
		public static void newexl() throws IOException
		{
			 wb = new HSSFWorkbook();
			 FileOutputStream	 fileOut = new FileOutputStream(path);
			wb.write(fileOut);
			fileOut.close();
		}
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel with SHeet Name And Column Names 
		
		public static void addsheet(String Sheet) throws IOException
		{
			newSheet=Sheet;
			FileOutputStream fileOut = new FileOutputStream(path);
			CreationHelper createHelper = wb.getCreationHelper();
			org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet(newSheet);
			Row row1 = sheet1.createRow((short) 0);
			row1.createCell(0).setCellValue(createHelper.createRichTextString("TestCase Name"));
			row1.createCell(1).setCellValue(createHelper.createRichTextString("Status"));
			row1.createCell(2).setCellValue(createHelper.createRichTextString("Exception"));
			wb.write(fileOut);
			fileOut.close();
			System.out.println( newSheet + " Sheet Added");
		}	
		
		

		// >>>>>>>>>>>>>>>>>>>>>>>>>>> Add or update Result of Test case in excel 
		
		public static void updateResult(String Methodname,String Status,String errormsg) throws EncryptedDocumentException, IOException
		{
			System.out.println(newSheet + "in writer");
			CreationHelper createHelper = wb.getCreationHelper();
			
			int rowcnt=wb.getSheet(newSheet).getLastRowNum();
			System.out.println(rowcnt);
			
			Row row1 = wb.getSheet(newSheet).createRow((short) rowcnt+1);
			row1.createCell(0).setCellValue(createHelper.createRichTextString(Methodname));
			row1.createCell(1).setCellValue(createHelper.createRichTextString(Status));
			row1.createCell(2).setCellValue(createHelper.createRichTextString(errormsg));

			FileOutputStream fileOut=new FileOutputStream(path);
			wb.write(fileOut);
			wb.close();
			System.out.println(Methodname + Status + "add to "+ newSheet);
		}
		
	// >>>>>>>>>>>>>>>>>>>>>>>>>>> read all excell data of same number of rows
	
	public static ArrayList<Object[]> readData2() throws EncryptedDocumentException, IOException
	{
		
		
		//String path="../Products/exes/PFinder.xlsx";
		System.out.println("inexcel");
//		FileInputStream file=new FileInputStream(path);
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "/exes/PFinder.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		ArrayList<Object[]> myobj = new ArrayList<Object[]>();
		int rowcnt=wb.getSheet("Sheet2").getLastRowNum();
		System.out.println(rowcnt);
		for(int i=1;i<=rowcnt;i++)
		{
			int cellcnt=wb.getSheet("Sheet2").getRow(i).getLastCellNum();
			Object[] obj = new Object[cellcnt];
			
			for(int c=0;c<cellcnt;c++)
			{
				String Name=wb.getSheet("Sheet2").getRow(i).getCell(c).toString();
				if(Name.equalsIgnoreCase("Null"))
					Name=" ";
				obj[c]=Name;
			}
			myobj.add(obj);
		}
		return myobj;
	}
	
	
	public static ArrayList<Object[]> readData3() throws EncryptedDocumentException, IOException
	{
		String path="../Branch2/NF/MyDate.xlsx";
		System.out.println("inexcel new");
		FileInputStream file=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		ArrayList<Object[]> myobj = new ArrayList<Object[]>();
		int rowcnt=wb.getSheet("Sheet2").getLastRowNum();
		System.out.println(rowcnt);
		for(int i=1;i<=rowcnt;i++)
		{
			String Name=wb.getSheet("Sheet2").getRow(i).getCell(0).toString();
			//int cellcnt=wb.getSheet("user_master").getRow(i).getLastCellNum();
			//Object[] obj = new Object[cellcnt];
	System.out.println(Name);
		}
		
		return null;
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>> update result to old excel file  
	
	public static void AddResultAt(String newSheet,int searchRownum,String UnicField,String Result,int rescellnum) throws EncryptedDocumentException, IOException
	{
	String path="../Branch2/exes/MytestXL.xlsx";
	FileInputStream file=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(file);
	int rowcnt=wb.getSheet(newSheet).getLastRowNum();
	
	for(int i=1;i<=rowcnt;i++)
	{
		String searchField=wb.getSheet(newSheet).getRow(i).getCell(searchRownum).toString();
		if(searchField.equalsIgnoreCase(UnicField))
		{
			//short Lastcell = wb.getSheet(newSheet).getRow(i).getLastCellNum();
			wb.getSheet(newSheet).getRow(i).getCell(rescellnum).setCellValue(Result);
			break;
		}
				
	}
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel Excel to save string array 
	
	public static void Altimg(String Sheet,ArrayList<String> ar) throws IOException
	{
		
		newSheet=Sheet;
		FileOutputStream fileOut = new FileOutputStream(path);
		CreationHelper createHelper = wb.getCreationHelper();
		org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet(newSheet);		
		int k=0;
		for (String st : ar) {
			System.out.println("printing " + st);
			sheet1.createRow((short) k).createCell(0).setCellValue(createHelper.createRichTextString(st));
		k++;
		}
		wb.write(fileOut);
		fileOut.close();
		System.out.println("done from me in altimg of " + newSheet);
	}
	

	
	public static void getdirectcellvalue(String Sheet,String findcollumn,String findrowmn) throws EncryptedDocumentException, IOException
	{
		newSheet=Sheet;
	String path="../Branch2/exes/MytestXL.xlsx";
	FileInputStream file=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(file);
	int rowcnt=wb.getSheet(newSheet).getLastRowNum();
	int celcnt=wb.getSheet(newSheet).getRow(0).getLastCellNum();
		
	for(int k=0;k<=celcnt;k++)
	{
		String xlcolname=wb.getSheet(newSheet).getRow(0).getCell(k).toString();
		if(xlcolname.equalsIgnoreCase(findcollumn))
		{
			for(int j=1;j<=rowcnt;j++)
			{
				String xlrowname=wb.getSheet(newSheet).getRow(j).getCell(0).toString();
				if(xlrowname.equalsIgnoreCase(findrowmn))
				{
					String celvalue=wb.getSheet(newSheet).getRow(j).getCell(k).toString();
					System.out.println(celvalue);
					break;
				}
				
			}
			break;
			
		}
	}
	
	}
	
}
