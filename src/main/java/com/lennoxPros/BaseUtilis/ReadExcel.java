package com.lennoxPros.BaseUtilis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFObjectData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.draw.geom.Formula;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

public class ReadExcel {
	
	protected String firstNam = null;
	protected String lastName = null;
	protected String phoneNo = null;
	protected String eMail = null;
	protected String dateVal = null;
	protected String schtime = null;
	protected String path=null;
	protected String ext=null;
	
	
	public void readFromExcel() {

	try
	{
		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\eclipse-workspace\\Assessment\\src\\main\\java\\com\\lennoxPros\\testData\\LeadDetails.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet("sheet1");
		int rowLength = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i <= rowLength; i++) {

			firstNam = sheet.getRow(i).getCell(0).getStringCellValue();
			lastName = sheet.getRow(i).getCell(1).getStringCellValue();
			phoneNo = sheet.getRow(i).getCell(2).getStringCellValue();
			eMail = sheet.getRow(i).getCell(3).getStringCellValue();
			dateVal = sheet.getRow(i).getCell(4).getStringCellValue();
			schtime = sheet.getRow(i).getCell(5).getStringCellValue();

			
			
			Cell cell = sheet.getRow(0).getCell(6);
			Hyperlink link = cell.getHyperlink();
			if(link != null){
				
			   path=link.getAddress();
			   
			}

			List<XSSFPictureData> lst = book.getAllPictures();
			for (Iterator it = lst.iterator(); it.hasNext();) {
				PictureData pict = (PictureData) it.next();
				 ext = pict.getContentType();
				
			}

		}

	}catch(Exception e)
	{
		e.printStackTrace();
	}
}}