public class LinkedListCycleII {

  public static void main(String[] args) {
    var solution = new Solution();
    var head = new ListNode(3,
        new ListNode(2,
            new ListNode(0,
                new ListNode(4))));

    head.next.next.next.next = head.next;

    System.out.println(solution.detectCycle(head));
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder("[");

    return sb.append("]").toString();
  }
}

class Solution {
  public ListNode detectCycle(ListNode head) {
    var slow = head;
    var fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        slow = head;

        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }

        break;
      }
    }

    return slow;
  }
}
