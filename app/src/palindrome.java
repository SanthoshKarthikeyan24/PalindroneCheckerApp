import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (int i = 0; i < input.length(); i++) {
            if (stack.pop() != input.charAt(i)) return false;
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Context class
class PalindromeCheckerContext {

    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main application
public class palindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1-Stack  2-Deque");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeCheckerContext context = new PalindromeCheckerContext(strategy);

        if (context.check(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}