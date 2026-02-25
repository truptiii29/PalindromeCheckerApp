public class UseCase13PalindromeCheckerApp {

    // Iterative approach
    public static boolean isPalindromeIterative(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive approach
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // StringBuilder reverse approach
    public static boolean isPalindromeReverse(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        long startTime, endTime;

        // Iterative
        startTime = System.nanoTime();
        boolean iterativeResult = isPalindromeIterative(input);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Recursive
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        startTime = System.nanoTime();
        boolean recursiveResult = isPalindromeRecursive(normalized, 0, normalized.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        // Reverse
        startTime = System.nanoTime();
        boolean reverseResult = isPalindromeReverse(input);
        endTime = System.nanoTime();
        long reverseTime = endTime - startTime;

        System.out.println("Input: " + input);
        System.out.println("Iterative Result: " + iterativeResult + " | Time: " + iterativeTime + " ns");
        System.out.println("Recursive Result: " + recursiveResult + " | Time: " + recursiveTime + " ns");
        System.out.println("Reverse Result: " + reverseResult + " | Time: " + reverseTime + " ns");
    }
}

