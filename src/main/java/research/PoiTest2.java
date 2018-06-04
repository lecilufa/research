package research;


import java.io.FileOutputStream;
import java.io.InputStream;

import javax.rmi.CORBA.Util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PoiTest2 {

	private XSSFWorkbook workbook;
	
	@Before
	public void init(){
		
		try{
			InputStream is = this.getClass().getResourceAsStream("/ASIA_VGM declaration.xlsx");
			
			workbook = new XSSFWorkbook(is);//创建Excel文件(Workbook)
			
			
		}catch(Exception e){
			e.printStackTrace();
			workbook = new XSSFWorkbook();
		}
	}
	

	//动态添加 行的代码  思路是先把下面的内容下移 N行  再在对应的位置创建N行 复制样式
	@Test
	public void testCase1() throws Exception{
		
		XSSFSheet	sheet = workbook.getSheetAt(0);
		
//		XSSFRow row = sheet.getRow(7);		
//		XSSFCell cell = row.getCell(1);		
//		cell.setCellValue("123abc");
		
		//第一个参数是 被移动的内容的起始行号 (行号从0开始计算 ) 
		//第二个参数是 被移动的内容的结束行号
		//第三个参数是移动多少行
		sheet.shiftRows(32, 51, 6);
		
		XSSFRow originalRow = sheet.getRow(30);
		XSSFCellStyle style = originalRow.getCell(0).getCellStyle();
		
		for(int i = 0; i < 6 ; i++){
			XSSFRow newRow = sheet.createRow(31 + i);
			newRow.setHeight(originalRow.getHeight());
			newRow.createCell(0).setCellStyle(style);
			newRow.createCell(1).setCellStyle(style);
		}
		
		
		
		
	}
	
	
	@Test
	public void testCase2() throws Exception{
		
		
		
		 
		
	}
	
	
	@After
	public void close() throws Exception{
		String filePath="C:/nico/sample.xlsx";//文件路径
		FileOutputStream out = new FileOutputStream(filePath);
		
		workbook.write(out);
		out.close();//关闭文件流
	}
}
