import java.io.*;
import java.lang.*;
import java.util.*;

public class OptimizedMergeSortLinkedList {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node left = head;
        Node right = slow.next;
        slow.next = null;

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        Node result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.value <= right.value) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        head = sort(head);

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}