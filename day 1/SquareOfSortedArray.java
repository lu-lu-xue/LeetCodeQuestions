public class SquareOfSortedArray {
    /*
        the largest only exist in two ends
        k -> end of the result
        i -> start of the left sorted
        j -> start of the right sorted
        large - > small
    */
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int k = nums.length - 1;
        while (i <= j){
            if (Math.abs(nums[i]) > Math.abs(nums[j])){
                res[k--] = nums[i] * nums[i];
                i++;
            } else {
                res[k--] = nums[j] * nums[j];
                j--;
            }
        }
        
        return res;
    }
}