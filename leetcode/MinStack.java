import java.util.Stack;

class MinStack {
    
    private Stack<Integer> actualS;
    private Stack<Integer> minS;
    
    public MinStack() {
        actualS = new Stack<Integer>();
        minS = new Stack<Integer>();
    }
    
    public void push(int x) {
        actualS.push(x);
        if (minS.isEmpty() || x <= minS.peek()) {
            minS.push(x);
        }
    }

    public void pop() {
        int poppedItem = actualS.pop();
        if (poppedItem == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return actualS.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
