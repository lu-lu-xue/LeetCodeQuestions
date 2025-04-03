import java.util.Queue;
import java.util.LinkedList;

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    

    // push it to the front of other elements
    public void push(int x) {
        q1.offer(x);
        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }

        // empty q1
        // put all of them in q2
        Queue<Integer> tmp;
        tmp = q1;
        q1 = q2; 
        q2 = tmp;
    }
    
    public int pop() {
        return q2.poll();
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */