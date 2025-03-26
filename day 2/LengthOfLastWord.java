
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        int n = s.length();
        int i = n - 1;
        int start = n;
        while (i >= 0) {
            if (s.charAt(i) != ' ' && start == n) {
                start = i;
                // length of 1
                if (i == 0) {
                    return 1;
                }
            } else if (s.charAt(i) == ' ' && start != n) {
                // first occurrence of ' '
                return start - i;
            } else if (s.charAt(i) != ' ' && i == 0) {
                // if there are no ' '
                return start - i + 1;
            }
            i--;
        }
        return -1;
    }
}
