class Solution {
    public int strStr(String haystack, String needle) {
        // corner case
        if (needle == null || needle.isEmpty()){
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        }

        // sliding window
        int i = 0;
        int j = 0;
        while (i < m - n + 1){
            while (i < m && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }

            if (i == m){
                return -1;
            }

            // find a valid start
            int start = i;
            i++;
            j++;
            // check if the window can reach 
            // the length of n
            while (i < m && j < n && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            
            if (j == n){
                // we find a valid window
                return i - j;
            } else {
                // go to find anther valid start
                i = start + 1;
                j = 0;
            }
        }

        return -1;
    }
}