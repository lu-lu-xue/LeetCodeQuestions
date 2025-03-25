/*
27. Remove Element
Solved
Easy

Topics
Companies

Hint
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
*/

public class RemoveEle {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int k = 0;
        int j = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[i] != val){
                nums[j++] = nums[i++];
                k++;
            } else {
                i++;
            }
        }
        return k;
    }
}