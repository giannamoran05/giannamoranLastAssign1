import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class SplitStack {

    // Method to split the stack into negative and non-negative numbers
    public static void splitStack(Stack<Integer> stack) {
        // Create a queue for auxiliary storage
        Queue<Integer> queue = new LinkedList<>();

        // Transfer all elements from the stack to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Create a stack for non-negative numbers and a stack for negative numbers
        Stack<Integer> negatives = new Stack<>();
        Stack<Integer> nonNegatives = new Stack<>();

        // Separate the numbers into negatives and non-negatives
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num < 0) {
                negatives.push(num);  // Push negative numbers to negatives stack
            } else {
                nonNegatives.push(num);  // Push non-negative numbers to nonNegatives stack
            }
        }

        // Put negative numbers back on the original stack (negative numbers go on bottom)
        while (!negatives.isEmpty()) {
            stack.push(negatives.pop());
        }

        // Put non-negative numbers back on the original stack (non-negative numbers go on top)
        while (!nonNegatives.isEmpty()) {
            stack.push(nonNegatives.pop());
        }
    }

    // Main method to test the SplitStack function
    public static void main(String[] args) {
        // First test case
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(-5);
        stack1.push(67);
        stack1.push(-45);
        stack1.push(67);
        stack1.push(9);
        stack1.push(0);
        stack1.push(-42);
        stack1.push(56);
        stack1.push(-7);

        System.out.println("Original Stack 1: " + stack1);
        splitStack(stack1);
        System.out.println("Stack 1 after split: " + stack1);

        // Second test case
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(-2);
        stack2.push(-3);
        stack2.push(4);
        stack2.push(-5);
        stack2.push(6);
        stack2.push(-7);
        stack2.push(8);
        stack2.push(9);

        System.out.println("\nOriginal Stack 2: " + stack2);
        splitStack(stack2);
        System.out.println("Stack 2 after split: " + stack2);
    }
}
