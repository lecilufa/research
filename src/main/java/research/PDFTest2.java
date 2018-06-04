package research;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;




public class PDFTest2 {

	@Before
	public void init(){
		
	}
	
	@After
	public void close(){
		
	}
	
	@Test
	public void testCase1() throws Exception{
		
		//String html = this.getClass().getResource("/ckk.html").getPath();
		
		String htmlFilePath = PDFTest2.class.getResource("/index.html").getPath();
		
		System.out.println(PDFTest2.class.getResource("/").getPath());
		
        OutputStream os = new FileOutputStream("C:/nico/samplePDF.pdf");       
        ITextRenderer renderer = new ITextRenderer();     
        
        ITextFontResolver fontResolver = renderer.getFontResolver();     
        fontResolver.addFont("/C:/nico/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);     
    
        renderer.setDocument(htmlFilePath);
                
        //解决图片的相对路径问题  
        
        String imgPath = "file:/C:/nico/Kula/research/target/classes/";      
        renderer.getSharedContext().setBaseURL(imgPath);  
        
        renderer.layout();      
        renderer.createPDF(os);    
          
        os.flush();  
        os.close();  
		
		
	}
	

	
}
