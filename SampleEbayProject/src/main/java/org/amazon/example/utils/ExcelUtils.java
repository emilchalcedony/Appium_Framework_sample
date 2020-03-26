package org.amazon.example.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.amazon.example.base.Helper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends Helper {

	public static void setExcelFile() throws Exception {

		try {
			fis = new FileInputStream(testdataPath);
			ExcelWBook = new XSSFWorkbook(fis);

			ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetName(0));

		} catch (Exception e) {

			throw (e);

		}

	}

	public static Object getCellData(int RowNum, int ColNum) throws Exception {

		setExcelFile();
		cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		switch (cell.getCellType()) {
		case STRING:

			CellData = cell.getStringCellValue();
			break;
		case NUMERIC:
			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			CellData = (int) cell.getNumericCellValue();
			break;

		default:
			break;

		}
		return CellData;

	}

	public static void setCellData(int RowNum, int ColNum, String value) throws Exception {

		ExcelWSheet.getRow(RowNum).getCell(ColNum).setCellValue(value);

		try {
			fos = new FileOutputStream(testdataPath);
			ExcelWBook.write(fos);

		} catch (Exception e) {

		}

	}

	 
	 
		
	

	

		
	

}
