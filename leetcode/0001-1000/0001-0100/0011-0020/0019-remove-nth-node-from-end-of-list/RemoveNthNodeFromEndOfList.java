public class RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.removeNthFromEnd(
            new ListNode(
                1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5))))),
            5));

    System.out.println(
        solution.removeNthFromEnd(
            new ListNode(
                1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5))))),
            2));
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

  public String toString() {
    var sb = new StringBuilder("[");

    sb.append(val);

    var t = next;

    while (t != null) {
      sb.append(" --> " + t.val);
      t = t.next;
    }

    sb.append("]");

    return sb.toString();
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    var temp = new ListNode(0, head);
    var fast = temp;
    var slow = temp;

    while (n-- > 0) {
      fast = fast.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return temp.next;
  }
}
