class PalindromeChecker {
    private String input;

    public PalindromeChecker(String input) {
        this.input = input;
    }

    public boolean checkPalindrome() {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
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
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "RaceCar";
        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}


