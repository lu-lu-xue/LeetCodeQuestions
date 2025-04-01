import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // sort
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < n - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int left = j + 1;
                int right = n - 1;
                while (left < right){
                    // edge case
                    // if the value is very large
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // de-duplicate
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }

                        // de-duplicate for right
                        // if (nums[right] == nums[right + 1])
                        while (left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }

        return result;
    }
}