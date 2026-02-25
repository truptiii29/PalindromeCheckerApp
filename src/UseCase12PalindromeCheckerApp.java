import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return normalized.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isPalindrome(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Inject StackStrategy
        PalindromeService stackService = new PalindromeService(new StackStrategy());
        System.out.println("Using StackStrategy: " +
                (stackService.isPalindrome(input) ? "Palindrome" : "Not Palindrome"));

        // Inject DequeStrategy
        PalindromeService dequeService = new PalindromeService(new DequeStrategy());
        System.out.println("Using DequeStrategy: " +
                (dequeService.isPalindrome(input) ? "Palindrome" : "Not Palindrome"));
    }
}
