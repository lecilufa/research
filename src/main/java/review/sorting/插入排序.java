package review.sorting;

public class 插入排序 {

	/**
	 * 此算法认为数组左边元素是有序的，右边是无序的， 每次从右边无序部分抽一个数 插入 左边有序的部分  使得左边变得有序
	 * 这样n-1趟之后 数组变为有序
	 * 复杂度 O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] { 3, 5, 4, 1, 2, 6, 8, 7 };
		
		int n = arr.length;
		
		for(int i = 1; i < n; i++){
			
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j-1]){
					swap(j,j-1,arr);
				}else{
					break;
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
