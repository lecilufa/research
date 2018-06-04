package research.model;

import java.text.DecimalFormat;

public class AAB {

	public static void main(String[] args) {
	
		Double a = 1.00;
		
		DecimalFormat df  =new DecimalFormat("#.00"); 
		
		System.out.println(df.format(a));
		
		double d = 3.1415926;
		String result = String.format("%.2f",a);
		System.out.println(result);


	}

}
