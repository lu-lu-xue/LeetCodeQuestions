
import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        // pop from stackOut
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }

        return stackOut.pop();
    }

    public int peek() {
        if (!stackOut.isEmpty()) {
            return stackOut.peek();
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
