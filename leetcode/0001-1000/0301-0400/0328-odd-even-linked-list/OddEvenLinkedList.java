public class OddEvenLinkedList {
  public static void main(String[] args) {
    //
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode leftHead = head;
    ListNode leftTail = head;

    ListNode rightHead = head.next;
    ListNode rightTail = head.next;

    ListNode node = head.next.next;
    ListNode previous = node;

    int i = 0;
    while (node != null) {
      previous = node;
      node = node.next;

      if (i % 2 == 0) {
        leftTail.next = previous;
        leftTail = leftTail.next;
      } else {
        rightTail.next = previous;
        rightTail = rightTail.next;
      }

      i++;
    }

    rightTail.next = null;
    leftTail.next = rightHead;

    return leftHead;
  }
}
