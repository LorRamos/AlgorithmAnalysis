public class DoublyLinkedList {

    private static class Node {
      int data;
      Node next;
      Node prev;

      public Node(int data) {
        this.data = data;
      }
    }

    public static Node mergeSort(Node head) {
      if (head == null || head.next == null) {
        return head;
      }

      Node middle = getMiddle(head);
      Node nextOfMiddle = middle.next;

      middle.next = null;

      Node left = mergeSort(head);
      Node right = mergeSort(nextOfMiddle);

      Node sortedList = merge(left, right);
      return sortedList;
    }

    private static Node merge(Node left, Node right) {
      Node result;

      if (left == null) {
        return right;
      }

      if (right == null) {
        return left;
      }

      if (left.data <= right.data) {
        result = left;
        result.next = merge(left.next, right);
      } else {
        result = right;
        result.next = merge(left, right.next);
      }

      return result;
    }

    private static Node getMiddle(Node head) {
      if (head == null) {
        return head;
      }

      Node slow = head, fast = head;

      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow;
    }

    public static void main(String[] args) {
      Node head = new Node(2);
      head.next = new Node(1);
      head.next.prev = head;
      head.next.next = new Node(4);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(3);
      head.next.next.next.prev = head.next.next;

      head = mergeSort(head);

      while (head != null) {
        System.out.print(head.data + " ");
        head = head.next;
      }
    }
  }