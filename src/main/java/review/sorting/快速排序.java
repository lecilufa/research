package review.sorting;

public class 快速排序 {

	/**
	 * 第一次从数组中抽取第一个元素 （或者随机一个元素也可以）  作为基准
	 * 做排序  使得数组左边的数都小于 这个基准， 右边的数大于这个基准
	 * 到此  第一趟完成
	 * 
	 * 然后对这个基准 左右两边的数组进行如上 一样的排序，   进行递归调用
	 * 
	 * 直到被排序的数组 只有一个元素为止，  递归结束
	 * 
	 * 
	 * 
	 * 回顾一下 第一趟完成时  其实这个基准在数组中的位置已经确认了  不管左右两边的数组是否有序  基准的位置必定就是他排序后的最终位置
	 * 重复这样的步骤就可以完成整个数组的排序
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] { 3, 5, 44, 1, 2, 66, 8, 7,33, 55, 4, 11, 22, 6, 88, 77,63 };		
/*	
 * 排序数组 = { 3, 5, 4, 1, 2, 6, 8, 7 }
 * 
 * { 3, 5, 4, 1, 2, 6, 8, 7 }
 * { 2, 5, 4, 1, 3, 6, 8, 7 }						  
 * { 2, 3, 4, 1, 5, 6, 8, 7 }
 * { 2, 1, 4, 3, 5, 6, 8, 7 }
 * { 2, 1, 3, 4, 5, 6, 8, 7 }              
 *  
 *  第一趟是这样的
 */

		
		int n = arr.length;
		
		quickSort(0,n-1,arr);
		
		for(int s : arr){
			System.out.print(s + " ");
		}
	}
	
	public static void quickSort(int begin, int end, int[] arr){
		
		if(end <= begin){
			return;
		}
		
		int i = begin;  //初始化
		int j = end;
		
		int k = begin; //初始化 记录基准 下标
				
		while(i < j){
			
			if(arr[j] < arr[k]){
				swap(j,k,arr);
				
				k = j;
				
				while(i < j){
					if(arr[i] > arr[k]){
						swap(i,k,arr);
						k = i;
						break;
					}else{
						i ++;
					}
				}				
			}else{
				j--;
			}
		}
	
		quickSort(begin,k-1,arr);
		quickSort(k+1,end,arr);
	}

	
	public static void swap(int i, int j,int[] arr){
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
