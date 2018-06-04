package review.sorting;

public class 倒序算法 {

	public static void main(String[] args) {
		
		int[] arr = new int[] { 1, 2, 3, 4,5, 6, 7  };
		
		int n = arr.length - 1;		
		int end = n / 2;
		
		for(int i=0; i <= end; i++){
			
			swap(i,n-i,arr);  //按照中间对称交换
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
