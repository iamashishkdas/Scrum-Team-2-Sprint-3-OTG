package com.t2s3.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;


	

public class Utility {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "xlsx";

	static JavascriptExecutor js;
	static Actions act;
	static WebDriver driver;
	public String path;

	public Utility(WebDriver driver) {

		Utility.driver = driver;

	}

	// *****************************READ_DATA_FROM_EXCEL************************************

	public  Object[][] readExcel(String filePath, String sheetName) throws IOException {
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

	public  String CaptureScreenshot(String filePath) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String absolutepathlocation=(new File(filePath).getAbsolutePath());
		Files.copy(screenshotFile, new File(filePath));
		return absolutepathlocation;

	}
	// **********************************CAPTURE_SCREENSHOT_SELECTEDELEMENT********************************
	public  String CaptureScreenshotofElement(WebElement element,String filePath) throws IOException {

		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		String absolutepathlocation=(new File(filePath).getAbsolutePath());
		Files.copy(screenshotFile, new File(filePath));
		return absolutepathlocation;



	}
//	public String getScreenShot(WebDriver drive, String screenshotName) throws IOException {
//        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir") + "/Screenshots/"+ screenshotName + dateName + ".png";
//        File scrshotLocation = new File(destination);
//        FileUtils.copyFile(source, scrshotLocation);
//        return destination;
//        }
	/*
	public String getScreenShot(WebDriver drive, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "./Reports/Screenshots/" + screenshotName + dateName + ".png";
        //String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File scrshotLocation = new File(destination);

        FileUtils.copyFile(source, scrshotLocation);

        return destination;

    }
    */
	public String getScreenShot(WebDriver drive, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "./Reports/Screenshots/" + screenshotName + dateName + ".png";
        //String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File scrshotLocation = new File(destination);

        FileUtils.copyFile(source, scrshotLocation);

        return destination;
    }
	public String captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64Code=ts.getScreenshotAs(OutputType.BASE64);
        return base64Code;

	}

}
