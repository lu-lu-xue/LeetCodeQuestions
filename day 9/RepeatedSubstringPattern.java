
class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // remove the first and the last
        String sub = doubled.substring(1, doubled.length() - 1);

        // this way is more efficient ???
        return sub.indexOf(s) != -1;

        // return isSub(sub, s);
    }

    private boolean isSub(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < m - n + 1) {
            while (i < m && s.charAt(i) != t.charAt(j)) {
                i++;
            }

            if (i == m) {
                return false;
            }

            int start = i;
            i++;
            j++;
            while (i < m && j < n && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return true;
            } else {
                i = start + 1;
                j = 0;
            }
        }

        return false;
    }
}
