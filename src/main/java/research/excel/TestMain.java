package research.excel;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		InputStream inputXML = new BufferedInputStream(TestMain.class.getResourceAsStream("departments.xml"));
        XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
        InputStream inputXLS = new BufferedInputStream(TestMain.class.getResourceAsStream("departmentdata.xls"));
        
        Department department = new Department();
        Department hrDepartment = new Department();
        List<Department> departments = new ArrayList<>();
        
        Map<String,Object> beans = new HashMap<>();
        beans.put("department", department);
        beans.put("hrDepartment", hrDepartment);
        beans.put("departments", departments);
        XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
        
        System.out.println(readStatus.isStatusOK());

	}

}
