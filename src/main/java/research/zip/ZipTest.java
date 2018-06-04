package research.zip;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.zeroturnaround.zip.NameMapper;
import org.zeroturnaround.zip.ZipUtil;

public class ZipTest {

	
	public static void main(String[] args) {
		
		//压缩文件
		//ZipUtil.pack(new File("C:/nicot/backup"), new File("C:/nicot/aa.zip"));
		
		File[] files = new File[]{
				new File("C:/nicot/2.txt"),new File("C:/nico/1.txt")
		};
		
		//加入压缩包后 给每个文件改名
		ZipUtil.packEntries(files, new File("C:/nicot/aa.zip"),new NameMapper() {
			
			@Override
			public String map(String name) {  //name 是原文件名
				
				String[] tempName =  name.split("\\.");
				
				String fileName = tempName[0];
				
				String subFix = tempName[1];
				
				return fileName + "_kk." + subFix;  //return是改过之后的文件名
			}
		});
		
		
		
		
		//解压缩
		//ZipUtil.unpack(new File("C:/nicot/aa.zip"), new File("C:/nicot/123"));
	}

	
	
}
