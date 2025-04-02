
class ReplaceNumber{
    public static String replaceDigit(String s){
        // corner case
        if (s == null || s.isEmpty()){
            return s;
        }
        int count = 0;
        int size = s.length();
        for (char c: s.toCharArray()){
            if (!(c >= 'a' && c <= 'z')){
                count++;
            }
        }

        int len = size + count * 5;
        char[] arr = new char[len];
        int i = 0;
        int j = 0;
        while (i < size){
            char cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z'){
                arr[j++] = cur;
            } else {
                arr[j++] = 'n';
                arr[j++] = 'u';
                arr[j++] = 'm';
                arr[j++] = 'b';
                arr[j++] = 'e';
                arr[j++] = 'r';
            }
            i++;
        }

        return new String(arr);
    }

    public static void main(String[] args){
        String s = "a1b2c3";
        System.out.println(replaceDigit(s));
    }
}