package review.sorting;

public class 选择排序 {

	/**
	 * 每一趟选出 最大的数 放到数组的 末端（或始端）
	 * 选了n-1趟得到有序数组
	 * 复杂度 O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 3, 5, 4, 1, 2, 6, 8, 7 };
		
		int n = arr.length;
		
		for(int i = 0;i < n-1; i++){
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[i] ){
					swap(j,i,arr);
				}
			}
		}
		
		for(int i = 0;i < n; i++){
			System.out.print(arr[i] + ", ");
		}
	}

	public static void swap(int i, int j,int[] arr){
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
