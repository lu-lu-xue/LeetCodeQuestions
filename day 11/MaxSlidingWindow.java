import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = -1; i < n - k; i++){
            for (int j = i + 1; j <= Math.min(i + k, n - 1); j++){
                if (stack.isEmpty()){
                    stack.push(nums[j]);
                } else if (nums[j] > stack.peek()){
                    stack.pop();
                    stack.push(nums[j]);
                }
            }
            res.add(stack.pop());
        }
        int size = res.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = res.get(i);
        }

        return result;
    }
}