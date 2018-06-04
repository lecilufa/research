package review.search;

public class 二分查找 {

	public static void main(String[] args) {

		int a[] = new int[] { 11, 22, 33, 44, 55, 66 };

		int res = Search(a, 44, 0, a.length-1);

		System.out.println(res);
	}

	/**
	 * 以下为概念算法， 算法思想的简化版，实际执行有bug， 在查找数组中不存在的数时会报异常，实际算法请看修正版
	 * 
	 * @param a
	 *            被搜索的数组
	 * @param value
	 *            被查找的数据
	 * @param low
	 *            数组下标 低位
	 * @param high
	 *            数组下标 高位
	 * @return 找到数的 下标
	 */
	public static int Search(int a[], int value, int low, int high) {

		int mid = low + (high - low) / 2;   //二分查找必须是有序数组   一次可以排除掉数组中一半的元素  比顺序查找快

		if (a[mid] == value) {
			return mid;
		} else if (value < a[mid]) {
			return Search(a, value, low, mid - 1);
		} else if (value > a[mid]) {
			return Search(a, value, mid + 1, high);
		}
		
		return -1; // 这句永远不可达

	}

}
