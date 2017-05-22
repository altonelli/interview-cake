import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class QueueWithTwoStacks {

    private static class MyQueue {
        Stack<Integer> stackOne;
        Stack<Integer> stackTwo;

        public MyQueue() {
            this.stackOne = new Stack<Integer>();
            this.stackTwo = new Stack<Integer>();
        }

        public void add(int num) {
            stackOne.push(num);
        }

        public Integer poll() {
            if (stackTwo.isEmpty()) {
                while (!stackOne.isEmpty())
                    stackTwo.push(stackOne.pop());
            }
            return stackTwo.pop();
        }

        public boolean isEmpty() {
            return stackOne.isEmpty() && stackTwo.isEmpty();
        }
    }

    public static void main(String[] args) {

        Queue<Integer> stdQueue = new LinkedList<Integer>();
        MyQueue myQueue = new MyQueue();
        Stack<Integer> stdStack = new Stack<Integer>();

        for (int i = 1; i < 10; i++) {
            stdQueue.add(i);
            myQueue.add(i);
            stdStack.add(i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.print(stdQueue.poll() + " ");
            System.out.print(myQueue.poll() + " ");
            System.out.println(stdStack.pop());
        }

        for (int i = 5; i <= 10; i++) {
            stdQueue.add(i);
            myQueue.add(i);
            stdStack.add(i);
        }

        while (!stdQueue.isEmpty()) {
            System.out.print(stdQueue.poll() + " ");
            System.out.print(myQueue.poll() + " ");
            System.out.println(stdStack.pop());
        }

    }
}

