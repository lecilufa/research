package research;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import research.model.ClassA;
import research.model.ClassB;
import research.xml.XmlUtil;

public class XMLTest {

	@Test
	public void testCase1() throws Exception {

		ClassB classB = new ClassB();
		classB.setClassBId(22);
		classB.setClassBName("B2");

		ClassA classA = new ClassA();
		classA.setClassAId(11);
		classA.setClassAName("A1");
		classA.setClassB(classB);

		String s = XmlUtil.toXML(classA);
		
		System.out.println(s);
		
		classA = XmlUtil.fromXML(s, ClassA.class);
		
		System.out.println(classA);
	}

}
