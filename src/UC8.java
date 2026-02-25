class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPalindromeChecker {
    private Node head;

    public void convertStringToList(String str) {
        for (char c : str.toCharArray()) {
            append(c);
        }
    }

    private void append(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);

        Node firstHalf = head;
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}

public class UC8 {
    public static void main(String[] args) {
        String input = "madam";
        LinkedListPalindromeChecker checker = new LinkedListPalindromeChecker();
        checker.convertStringToList(input);

        if (checker.isPalindrome()) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}