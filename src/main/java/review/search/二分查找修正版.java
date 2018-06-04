package review.search;

public class 二分查找修正版 {

	public static void main(String[] args) {
		
		int a[] = new int[]{
			11,22,33,44,55,66	
		};
		
		int res = Search(a,44,0,5);
		
		System.out.println(res);
	}

	/**
	 * 
	 * @param a			被搜索的数组
	 * @param value     被查找的数据
	 * @param low		数组下标     低位
	 * @param high      数组下标     高位
	 * @return			找到数的 下标
	 */
	public static int Search(int a[], int value, int low, int high){
		
		if(low > a.length - 1){
			return -1;
		}
		if(high < 0){
			return -1;
		}
		
	    int mid = low+(high-low)/2;
	    
	    if(a[mid]==value){
	    	return mid;
	    }else {
	    	
	    	if(low == high){
				return -1;
			}
	    	
	    	if(value < a[mid]){
		    	return Search(a, value, low, mid-1);
		    }else if(value > a[mid]){
		    	return Search(a, value, mid+1, high);
		    }else{
		    	return -1; //这句永远不可达
		    }
	    }
	    
	        
	}
	
}
