import java.util.*;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class palindrome {

    public static boolean charArrayPalindrome(String input) {
        char[] arr = input.toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++; end--;
        }
        return true;
    }

    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) stack.push(ch);
        for (int i = 0; i < input.length(); i++) {
            if (stack.pop() != input.charAt(i)) return false;
        }
        return true;
    }


    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string for performance test: ");
        String input = scanner.nextLine();

        Map<String, Long> times = new LinkedHashMap<>();


        long start = System.nanoTime();
        charArrayPalindrome(input);
        long end = System.nanoTime();
        times.put("Char Array", end - start);

        // Stack
        start = System.nanoTime();
        stackPalindrome(input);
        end = System.nanoTime();
        times.put("Stack", end - start);

        // Deque
        start = System.nanoTime();
        dequePalindrome(input);
        end = System.nanoTime();
        times.put("Deque", end - start);

        // Recursive
        start = System.nanoTime();
        recursivePalindrome(input, 0, input.length() - 1);
        end = System.nanoTime();
        times.put("Recursive", end - start);

        // Display results
        System.out.println("\nPalindrome Algorithm Performance (nanoseconds):");
        for (Map.Entry<String, Long> entry : times.entrySet()) {
            System.out.printf("%-10s : %d ns%n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }
}