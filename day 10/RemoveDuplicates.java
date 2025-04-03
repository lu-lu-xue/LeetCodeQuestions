class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 2){
            return s;
        }

        int size = s.length();
        char[] arr = s.toCharArray();
        int i = -1;
        for (int k = 0; k < size; k++){
            if (i != -1 && arr[k] == arr[i]){
                // i != -1 -> stack is not empty
                // and new value == the top of the stack
                i--;
            } else {
                // i == -1 -> stack is empty, push
                // i != -1 && new value != top of the stack
                arr[++i] = arr[k];
            }
        }

        // the valid length of the result is i
        return new String(arr, 0, i + 1);
    }
}