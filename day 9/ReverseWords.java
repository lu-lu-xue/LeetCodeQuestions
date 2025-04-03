
class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int size = s.length();
        int i = 0, j = size - 1;

        // remove leading spaces
        while (i < size && s.charAt(i) == ' ') {
            i++;
        }
        // remove trailing spaces
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }

        // revere the whole string first
        char[] arr = s.toCharArray();
        reverse(arr, i, j);

        // reverse each word
        // and skip repeated spaces
        // start
        int start = i;
        for (int k = i; k <= j; k++) {
            // skip duplicate space
            while (k > i && arr[k] == ' ' && arr[k - 1] == ' ') {
                k++;
            }

            // record the valid char
            // could be a single space or non-space char
            arr[start++] = arr[k];
        }

        // reverse each word in [i, start-1]
        reverseWord(arr, i, start - 1);

        // new String(char[], int i, int lengthOfTheSubArr)
        return new String(arr, i, start - i);
    }

    private void reverseWord(char[] array, int start, int end) {
        int k = 0;
        for (int i = start; i <= end; i++) {
            // the start index of a word
            if (array[i] != ' ' && (i == start || array[i - 1] == ' ')) {
                k = i;
            }
            // the end index of a word
            if (array[i] != ' ' && (i == end || array[i + 1] == ' ') && k != i) {
                // reverse the interval of array [start, i]
                reverse(array, k, i);
            }
        }
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
