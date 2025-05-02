public class ReverseLinkedList {
  public static void main(String[] args) {
    // System.out.println(new Solution().reverseList);
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode previous = null;
    ListNode temp = null;

    while (head != null) {
      temp = head.next;
      head.next = previous;
      previous = head;
      //
      head = temp;
    }

    return previous;
  }
}

