import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }

        int size = tokens.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++){
            String c = tokens[i];
            if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")){
                int result = operator(c, stack);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(c));
            }
        }

        return stack.pop();
    }

    private int operator(String c, Deque<Integer> stack){
        int c2 = stack.pop();
        int c1 = stack.pop();
        if (c.equals("+")){
            return c1 + c2;
        } else if (c.equals("-")){
            return c1 - c2;
        } else if (c.equals("/")){
            return c1 / c2;
        } else {
            return c1 * c2;
        }
    }
}