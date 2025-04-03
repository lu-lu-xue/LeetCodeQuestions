
class ReverseStringByN {

    public String reverseStringByN(String s, int n) {
        if (s == null || s.length() < 2 || n == 0) {
            return s;
        }

        int size = s.length();
        // reverse the string
        char[] array = s.toCharArray();
        reverseString(array, 0, size - 1);

        // reverse
        reverseString(array, 0, n - 1);
        reverseString(array, n, size - 1);

        return new String(array);
    }

    private void reverseString(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
