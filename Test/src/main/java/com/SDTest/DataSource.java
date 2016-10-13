package com.SDTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.graphbuilder.struc.LinkedList;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @author Sunil Verma
 */
public class DataSource {

	static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	    return workbook;
	}
	
	public static HashMap readSheetNumber(File fileName, int sheetNumber) throws FileNotFoundException, IOException {
		String myFilePath = "\\src\\test\\resources\\testdata\\loginData.xlsx";
		File excelFile = new File(myFilePath);
		FileInputStream inputStream = new FileInputStream(fileName);
		Workbook workbook = getWorkbook(inputStream, fileName.getAbsolutePath());
		Sheet mySheet = workbook.getSheetAt(sheetNumber);
		String sheetName = mySheet.getSheetName();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		//Iterate through each rows from first sheet
		Iterator<Row> rowIterator = mySheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			String key = "";
			int value = Integer.MIN_VALUE; // use a default value that will never occur in the sheet

			while(cellIterator.hasNext()) 
			{
				Cell cell = cellIterator.next();
// Check Key and Value
				value = (int) cell.getNumericCellValue();
				key = cell.getStringCellValue();
			}

			if(key != "" && value != Integer.MIN_VALUE)
			{
				map.put(key, value);
				key = null;
				value = Integer.MIN_VALUE;
			}
		}
		inputStream.close();
		return map;
	}
}