package research;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VelocityTest {

	@Before
	public void init() throws Exception {

	}

	@Test
	public void testCase1() throws Exception {
		
		// 初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		// 取得velocity的模版
		Template t = ve.getTemplate("src/main/resources/hellovelocity.html");
		// 取得velocity的上下文context
		VelocityContext context = new VelocityContext();
		// 把数据填入上下文
		context.put("name", "Liang &");
		context.put("date", (new Date()).toString());
		// 为后面的展示，提前输入List数值
		List<String> temp = new ArrayList<String>();
		temp.add("1");
		temp.add("2");
		context.put("list", temp);
		// 输出流
//		StringWriter writer = new StringWriter();
		
		PrintWriter writer =new PrintWriter("C:/nico/ckk.html");
		
		// 转换输出
		t.merge(context, writer);
		
		writer.flush();
		
		writer.close();
		//System.out.println(writer.toString());
		
		

	}

	@After
	public void close() throws Exception {

	}

}
