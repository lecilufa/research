package research;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

public class PDFTest22 {

	public static void main(String[] args) throws Exception {

		//String html = PDFTest22.class.getResource("/ckk.html").getPath();

		String html = PDFTest22.class.getResource("/index.html").getPath();

		OutputStream os = new FileOutputStream("D:/nico/samplePDF.pdf");
		ITextRenderer renderer = new ITextRenderer();

		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		renderer.setDocument(html);

		// 解决图片的相对路径问题
		String basePath = "file:" + PDFTest22.class.getResource("/").getPath();
		// String imgPath = "file:/C:/nico/Kula/research/target/classes/";
		renderer.getSharedContext().setBaseURL(basePath);

		renderer.layout();
		renderer.createPDF(os);

		os.flush();
		os.close();

	}

}
