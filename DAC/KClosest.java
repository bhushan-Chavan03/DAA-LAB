import java.util.Arrays;

public class KClosest {
	
		static void findKClosestElements(int[] nums, int target, int k, int n) {
		int left = 0;
		int right = n - 1;

		
		while (right - left >= k) {
			if (Math.abs(nums[left] - target) > Math.abs(nums[right] - target)) {
				left++;
			} else {
				right--;
			}
		}

		
		while (left <= right) {
			System.out.print(nums[left] + " ");
			left++;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int n = nums.length;

		int target = 35, k = 4;

		
		findKClosestElements(nums, target, k, n);
	}
}
