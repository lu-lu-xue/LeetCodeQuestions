
import java.util.HashSet;
import java.util.Set;

class IsHappy {

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        while (n > 1 && !visited.contains(n)) {
            visited.add(n);
            n = helper(n);
        }

        return n == 1;
    }

    private int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int remaining = n % 10;
            sum += remaining * remaining;
            n = n / 10;
        }

        return sum;
    }

}
