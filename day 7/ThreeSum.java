
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    sort the array first
    using two-pointer method
 */
class ThreeSum {

    public List<List<Integer>> allTriples(int[] array) {
        // corner case
        if (array == null || array.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        // sort
        Arrays.sort(array);

        int n = array.length;
        for (int i = 0; i < n; i++) {
            // skip duplicates
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            // determine the other two ele
            int left = i + 1;
            int right = n - 1;

            // there are two elements
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == 0) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    right--;
                    // skip duplicates
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }

                    while (left < right && array[right] == array[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
