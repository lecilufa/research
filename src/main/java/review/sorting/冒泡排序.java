package review.sorting;

public class 冒泡排序 {

	/**
	 * 两两相邻比较  第一趟 必将最大数(或者最小数) 排到数组的末端  （或者始端）
	 * 每一趟都会把最大数排到数组末端    经过n-1趟  数组有序
	 * 复杂度 O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
				
		int[] arr = new int[] { 3, 5, 4, 1, 2, 6, 8, 7 };
		
		int n = arr.length;
		
		for(int i = n-1; i > 0; i--){
			
			for(int j = 0; j < i  ;j++ ){  
				
				if(arr[j] >  arr[j+1]){
					swap(j,j+1,arr);
				}
			}			
		}
		

		for(int s : arr){
			System.out.print(s + " ");
		}
	}
	
	
	public static void swap(int i, int j,int[] arr){
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
