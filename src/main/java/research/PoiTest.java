package research;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PoiTest {

	private XSSFWorkbook workbook;
	
	@Before
	public void init(){
		workbook = new XSSFWorkbook();//创建Excel文件(Workbook)
		
	}
	

	@Test
	public void testCase1() throws Exception{
		
		int a = Integer.parseInt("100");
		System.out.println(a);
	}
	
	
	@Test
	public void testCase2() throws Exception{
		
		
		
		 
		
		XSSFSheet sheet = workbook.createSheet("ckk");//创建工作表(Sheet)
		//sheet.setColumnWidth(0, 50 * 256);
		
		XSSFRow row = null;
		XSSFCell cell = null;
		
		
		XSSFFont  font = workbook.createFont();
		
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD); //字体变粗
		
		XSSFCellStyle style = workbook.createCellStyle();
		
		style.setFont(font);
		
		style.setWrapText(true);
		
		
//		style.setFillForegroundColor(XSSFColor.GREY_25_PERCENT.index);

//		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		//  设置单元格自动换行
		//XSSFCellStyle style2 = workbook.createCellStyle();
		//style2.setWrapText(true);
		
		for(int i = 0; i < 100; i ++){
			row = sheet.createRow(i);
		
			cell = row.createCell(0);			
			
			
			
		//	cell.setCellStyle(style2);  设置单元格自动换行
			
			XSSFRichTextString text = new XSSFRichTextString("李志伟 fgdf \r\n 123");
			
			cell.setCellValue(text);
			row.createCell(1).setCellValue(false);
			row.createCell(2).setCellValue(new Date());
			row.createCell(3).setCellValue(-12.345);
			
			if(i == 0){
				row.getCell(0).setCellStyle(style);
				row.getCell(1).setCellStyle(style);
				row.getCell(2).setCellStyle(style);
				
				style = workbook.createCellStyle();
				
				style.setDataFormat(workbook.createDataFormat().getFormat("\"\"#,##0.00_);[Red](\"\"#,##0.00)"));
				
				row.getCell(3).setCellStyle(style);
			}
		}	
		
		
		/*

		FileInputStream stream=new FileInputStream("C:/nico/123.jpg");
		byte[] bytes=new byte[(int)stream.getChannel().size()];
		stream.read(bytes);//读取图片到二进制数组
		int pictureIdx = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG);
		XSSFDrawing patriarch = sheet.createDrawingPatriarch();
		
		
		
		XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, -90000, -90000, (short)0, 0, (short)3, 3);
		XSSFPicture pict = patriarch.createPicture(anchor, pictureIdx);
		
		
		
		sheet.getRow(0).setHeight((short) 8000);
		*/
	}
	
	
	@After
	public void close() throws Exception{
		String filePath="C:/nico/sample.xlsx";//文件路径
		FileOutputStream out = new FileOutputStream(filePath);
		
		
		//输出到内存用ByteArrayOutputStream   ByteArrayInputStream 操作
//		ByteArrayOutputStream bo = new ByteArrayOutputStream();
//		
//		byte[] b = bo.toByteArray();
//		
//		System.out.println(b.length);
//		
//		ByteArrayInputStream io = new ByteArrayInputStream(b);
//		
//		bo.close();
//		
//		workbook.write(bo);
		

		workbook.write(out);
		out.close();//关闭文件流
	}
	
	
	public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:/nico/aa.xlsx")));
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFCell cell = sheet.getRow(2).getCell(1);
		
		//System.out.println(cell.getRawValue());
		
		cell.setCellFormula("R1C1 + R2C1");
		
		String filePath="C:/nico/abc.xlsx";
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);
		
		out.close();
		
	}
}
