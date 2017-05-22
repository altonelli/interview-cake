import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> max;

    public static MaxStack() {
        this.stack = new Stack<Integer>();
        this.max = new Stack<Integer>();
    }

    public int push(int num) {
        stack.push(num);
        if (num >= (int) max.peek()) {
            max.push(num);
        }
        return num;
    }

    public int pop() {
        int popped = (int) stack.pop();
        if (popped == (int) max.peek()) {
            max.pop();
        }
        return popped;
    }

    public int getMax() {
        return (int) max.peek();
    }

    public static void main(String[] args) {

    }
}