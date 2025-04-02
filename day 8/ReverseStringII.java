
class ReverseStringII {

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty() || k < 1) {
            return s;
        }

        int size = s.length();
        char[] arrayS = s.toCharArray();

        // reverse k elements
        // update: i += 2 * k
        for (int i = 0; i < size; i += 2 * k) {
            arrayS = reverse(arrayS, i, k);
        }

        return new String(arrayS);
    }

    private char[] reverse(char[] s, int start, int dist) {
        // if start + dist is out of range
        // take the length to be end
        int end = Math.min(start + dist, s.length) - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }

        return s;
    }
}
