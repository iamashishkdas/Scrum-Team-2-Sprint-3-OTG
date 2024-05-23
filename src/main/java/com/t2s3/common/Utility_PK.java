package com.t2s3.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.*;

import com.google.common.io.Files;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


	

public class Utility_PK {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "xlsx";

	static JavascriptExecutor js;
	static Actions act;
	//static WebDriver driver;
	public String path;

	/*public Utility(WebDriver driver) {

		Utility.driver = driver;

	}*/

	// *****************************READ_DATA_FROM_EXCEL************************************

	public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
		new File(filePath);
		FileInputStream inputStream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("Total row = " + sheet.getLastRowNum());
		System.out.println("Total cell = " + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}


	// **********************************CAPTURE_SCREENSHOT_CURRENTPAGE********************************

	public static void CaptureScreenshot(WebDriver driver, String filePath) throws IOException, InterruptedException {
		Thread.sleep(1000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File(filePath));

	}
	// **********************************CAPTURE_SCREENSHOT_SELECTEDELEMENT********************************
	public static String CaptureScreenshotofElement(WebElement element,String filePath) throws IOException {

		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		String absolutepathlocation=(new File(filePath).getAbsolutePath());
		Files.copy(screenshotFile, new File(filePath));
		return absolutepathlocation;
	}
	
	public static boolean isFileDownloaded(String fileName) {
		String home = System.getProperty("user.home");
		File dir = new File(home+"/Downloads/");  
		File[] dirContents = dir.listFiles();
		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		    	 dirContents[i].delete();
		          return true;
		      }
		  }
		      return false;
	}
	
	public static String GetScreenshotPath(String screenshotPath, String testMethodName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String screenName = testMethodName + "-" + dateFormat.format(date).replace(" ", "-") + ".png";
		String screenPath = Paths.get(screenshotPath, screenName).toString();
		return screenPath;
	}
	
	public static String GetRandomString(int stringLength)
	{
		String set = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < stringLength ; i++) {
			sb.append(set.charAt(random.nextInt(set.length())));
		}		
		return sb.toString();		
	}
	
	public static String CaptureScreenshot(WebDriver driver, String screenshotDir, String testMethodName) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String screenName = testMethodName + "-" + dateFormat.format(date).replace(" ", "-") + ".png";
		String screenShotPath = Paths.get(System.getProperty("user.dir"),screenshotDir, screenName).toString();		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File(screenShotPath));
		return screenShotPath;
	}
	
	public static String GetTodaysDate(String format)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date).replace(" ", "-");
	}
	public static File GetDownloadsDir()
	{
		String home = System.getProperty("user.home");
		File dir = new File(home+"/Downloads/");  
		return dir;
	}
	
	public static String GetMatchingFileName(final String startsWith) throws Exception
	{
		File dir =  GetDownloadsDir();
		FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
				return name.startsWith(startsWith);
			}
		};
		
		String[] fileName = dir.list(filter);
		if(fileName.length > 1)
		{	
			throw new Exception("With similar name more than one file exist in the specified directory.");
		}
		else if(fileName.length ==0)
		{
			return null;		
		}
		
		return fileName[0];		
	}
	
	public static boolean DeleteFileFromDownloadsDir(String fileName) {
		String home = System.getProperty("user.home");
		File dir = new File(home+"/Downloads/");  
		File[] dirContents = dir.listFiles();
		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		    	 dirContents[i].delete();
		          return true;
		      }
		  }
		      return false;
	}
	
	
	
}
