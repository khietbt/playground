import java.security.DrbgParameters.NextBytes;

public class SwappingNodesInALinkedList {

  public static void main(String[] args) {
    var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    var solution = new Solution();

    print(head);
    print(solution.swapNodes(head, 1));
  }

  static void print(ListNode head) {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
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
  public ListNode swapNodes(ListNode head, int k) {
    var dummy = new ListNode(-1, head);
    var fast = dummy;
    var slow = dummy;

    while (k-- > 0) {
      fast = fast.next;
    }

    var nFromBeginning = fast;

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    var nFromEnd = slow.next;

    var t = nFromBeginning.val;
    nFromBeginning.val = nFromEnd.val;
    nFromEnd.val = t;

    return dummy.next;
  }
}
