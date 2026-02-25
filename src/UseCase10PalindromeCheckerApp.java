public class UseCase10PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
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

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        if (isPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome (ignoring case and spaces).");
        }
    }
}

