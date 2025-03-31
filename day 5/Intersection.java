
import java.util.HashSet;
import java.util.Set;

class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // storing unique result
        Set<Integer> result = new HashSet<>();
        // corner case
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int size = result.size();
        int[] res = new int[size];

        // convert set to array
        int i = 0;
        for (int j : result) {
            res[i++] = j;
        }

        return res;
    }
}
