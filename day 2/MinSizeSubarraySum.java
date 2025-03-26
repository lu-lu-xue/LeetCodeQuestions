public class MinSizeSubarraySum {
    public static int minSizeSubarraySum(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }

        // we can use sliding window
		int left = 0, right = 0;
		int n = nums.length;
		int sum = 0;
		int globalMin = Integer.MAX_VALUE;
		while (right < n){
			sum += nums[right];
			
			while (sum >= target){
				globalMin = Math.min(globalMin, right - left + 1);
				sum -= nums[left];
				left++;
			}
			
			right++;
		}
		
		return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
    }
}
