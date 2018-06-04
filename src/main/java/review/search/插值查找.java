package review.search;

public class 插值查找 {

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

		double percentage = (value - a[low]) / (a[high] - a[low]);
		double position = (high - low) * percentage;
		int mid = low + (int)position;  //插值查找和二分查找的唯一不同点就是  如何求mid
										//通过 目标值value 占总值的比例，确定目标值在数组中的近似位置
										//这种算法对于均匀增长的有序数组特别有效   时间复杂度低      对于非均匀的数组   效率还不如二分查找
										//因为均匀增长的数组 value 占总值的比例 就是他在数组中的位置 ，因此能很快找到     
										//如果不想均匀增长 则比例毫无意义  相当于乱找  相率则低下

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
