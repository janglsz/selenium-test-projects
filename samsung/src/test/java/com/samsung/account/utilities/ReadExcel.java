package com.samsung.account.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	// Excel Workbook Object
	XSSFWorkbook workBook;
	
	// Excel Sheet
	XSSFSheet sheet1;
	
	// Constructor 
	public ReadExcel(String excelPath, String sheetName) {
		
		try {
			// Create and initialise the File object
			File excelFile = new File(excelPath);
			
			// Check if the file exists
			if (!excelFile.exists()) {
				
				// Print an error message to the console
				System.out.println("ExcelFile: " + excelPath + " does not exist");
				
			} else {
				
				// Input stream used to read the contents of the file
				FileInputStream fileInputStream = new FileInputStream(excelFile);
				
				// Get the Workbook using the FileInputStream
				workBook = new XSSFWorkbook(fileInputStream);
				
				// Get the Sheet
				sheet1 = workBook.getSheet(sheetName);
			}
		} catch (Exception e) {
			
			// Print Exception error message to the console
			System.out.println(e.getMessage());
		}	
	}
	
	
	/**
	 * This method gets the String data from the specified row and column in the Sheet
	 * 
	 * @param row		The row in the spreadsheet
	 * @param col		The column in the spreadsheet
	 * @return data		The extracted String data from the specified row and column	
	 */
	public String getStringData(int row, int col) {
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	
	/**
	 * This method gets the Numeric data from the specified row and column in the Sheet
	 * 
	 * @param row		The row in the spreadsheet
	 * @param col		The column in the spreadsheet
	 * @return data		The extracted String data from the specified row and column	
	 */
	public String getNumericData(int row, int col) {
		String data = sheet1.getRow(row).getCell(col).getRawValue();
		return data;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		ReadExcel excelFile = new ReadExcel("C:\\Users\\Admin\\eclipse-workspace\\testproject\\src\\test\\resources\\Test_Data.xlsx", "Sheet1");
		
		System.out.println("Test data contains: ");
		System.out.println("1-email:" + excelFile.getStringData(1,0));
		System.out.println("2-Incorrect Password:" + excelFile.getStringData(1,1));
		System.out.println("3-Correct Password:" + excelFile.getStringData(1,2));
	}
	
}
