public class SingleLinkedListMerge {
	private static class Node {
	        int value;
	        Node next;

	        public Node(int value) {
	            this.value = value;
	        }
	    }

	    private Node head;
	    private int size;

	    public void add(int value) {
	        Node newNode = new Node(value);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	        size++;
	    }

	    public void sort() {
	        head = mergeSort(head);
	    }

	    private Node mergeSort(Node node) {
	        if (node == null || node.next == null) {
	            return node;
	        }

	        Node middle = getMiddle(node);
	        Node right = middle.next;
	        middle.next = null;

	        Node left = mergeSort(node);
	        right = mergeSort(right);

	        return merge(left, right);
	    }

	    private Node getMiddle(Node node) {
	        if (node == null) {
	            return node;
	        }

	        Node slow = node;
	        Node fast = node;

	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }

	        return slow;
	    }

	    private Node merge(Node left, Node right) {
	        if (left == null) {
	            return right;
	        }

	        if (right == null) {
	            return left;
	        }

	        if (left.value < right.value) {
	            left.next = merge(left.next, right);
	            return left;
	        } else {
	            right.next = merge(left, right.next);
	            return right;
	        }
	    }
	    
	    void printList(Node head2)
		{
			while (head2 != null) {
				System.out.print(head2.value + " ");
				head2 = head2.next;
			}
		}
	    
	    public static void main(String[] args) {
	    	SingleLinkedListMerge list = new SingleLinkedListMerge();
	    	list.add(5);
	    	list.add(2);
	    	list.add(7);
	    	list.sort();
	    	list.printList(list.head);
	    }
}
	
