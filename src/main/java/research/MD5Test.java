package research;

import java.io.File;
import java.io.OutputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5Test {





	@Test
	public void testCase2() throws Exception {
		
		String str = "123";
		
		String s = DigestUtils.md5Hex(str);
				
		System.out.println(s);
		
		byte b = (byte) 179;
		
		
		
		String ss = Integer.toHexString(b & 0xFF);
		System.out.println(ss);

	}


	


}
