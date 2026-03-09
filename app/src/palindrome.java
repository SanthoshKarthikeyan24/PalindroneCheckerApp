import java.util.Scanner;
import java.util.Stack;

public class palindrome {

    // Inner class for palindrome checking
    static class PalindromeChecker {

        private Stack<Character> stack;

        // Constructor
        public PalindromeChecker() {
            stack = new Stack<>();
        }

        // Method to check palindrome
        public boolean checkPalindrome(String input) {

            stack.clear(); // Clear stack for repeated use

            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }

            for (int i = 0; i < input.length(); i++) {
                if (stack.pop() != input.charAt(i)) {
                    return false;
                }
            }

            return true;
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}