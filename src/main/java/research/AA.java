package research;

import java.math.BigDecimal;

public class AA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double doubleValue = 6601.285;
		
		BigDecimal b =  new  BigDecimal(doubleValue);  
		
		System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		System.out.println(
				new BigDecimal("6601.285").setScale(2, BigDecimal.ROUND_HALF_UP)
				);
		
	}

}
