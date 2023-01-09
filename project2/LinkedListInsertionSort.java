import java.util.LinkedList;

public class LinkedListInsertionSort {

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

	        Node sorted = head;
	        head = head.next;
	        sorted.next = null;

	        while (head != null) {
	            Node current = head;
	            head = head.next;

	            if (current.value < sorted.value) {
	                current.next = sorted;
	                sorted = current;
	            } else {
	                Node search = sorted;
	                while (search.next != null && search.next.value < current.value) {
	                    search = search.next;
	                }
	                current.next = search.next;
	                search.next = current;
	            }
	        }

	        return sorted;
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
