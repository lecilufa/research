package research.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {

	/**
	 * 把Object序列化成byte数组
	 */
	public static byte[] serialize(Object object) throws Exception {
		
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			byteOut = new ByteArrayOutputStream();
			objOut = new ObjectOutputStream(byteOut);

			objOut.writeObject(object);

			return byteOut.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(objOut != null){
				objOut.close();
			}
			if(byteOut != null){
				byteOut.close();
			}
		}
	}

	/**
	 * 把byte数组反序列化成Object
	 */
	public static Object unserialize(byte[] bytes) throws Exception {

		ByteArrayInputStream byteIn = null;
		ObjectInputStream objIn = null;

		try {
			byteIn = new ByteArrayInputStream(bytes);
			objIn = new ObjectInputStream(byteIn);

			return objIn.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(objIn != null){
				objIn.close();
			}
			if(byteIn != null){
				byteIn.close();
			}
		}
	}
	


	
}
