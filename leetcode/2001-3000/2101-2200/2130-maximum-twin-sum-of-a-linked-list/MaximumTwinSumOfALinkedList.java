public class MaximumTwinSumOfALinkedList {
  public static void main(String[] args) {
    // jj
    // [5,4,2,1]
    ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));

    System.out.println(new Solution().pairSum(head));
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

  static void print(ListNode head) {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

class Solution {
  ListNode reverse(ListNode head) {
    ListNode reverse = null;
    ListNode node = head;

    while (head != null) {
      node = head;
      head = head.next;

      node.next = reverse;
      reverse = node;
    }

    return reverse;
  }

  ListNode findMiddle(ListNode head) {
    ListNode dummy = new ListNode(0, head);

    ListNode slow = dummy;
    ListNode fast = dummy;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow.next;
  }

  public int pairSum(ListNode head) {
    if (head.next == null) {
      return head.val;
    }

    if (head.next.next == null) {
      return head.val + head.next.val;
    }

    ListNode middle = findMiddle(head);

    ListNode reversed = reverse(middle);

    int val = Integer.MIN_VALUE;

    while (reversed != null && head != null) {
      val = Math.max(val, reversed.val + head.val);

      reversed = reversed.next;
      head = head.next;
    }

    return val;
  }
}
