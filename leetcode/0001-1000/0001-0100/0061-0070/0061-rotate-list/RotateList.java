public class RotateList {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.rotateRight(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
            2));

    System.out.println(
        solution.rotateRight(
            new ListNode(0, new ListNode(1, new ListNode(2))),
            4));
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

  @Override
  public String toString() {
    var sb = new StringBuilder();

    sb.append("[" + val);

    var c = next;

    while (c != null) {
      sb.append(" --> " + c.val);
      c = c.next;
    }

    sb.append("]");
    return sb.toString();
  }
}

class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }

    var t = new ListNode(0, head);

    var n = 0;
    while (head != null) {
      n++;
      head = head.next;
    }

    k = k % n;

    if (k == 0) {
      return t.next;
    }

    var slow = t;
    var fast = t;

    while (k-- > 0) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    var node = t.next;

    fast.next = node;
    t.next = slow.next;
    slow.next = null;

    return t.next;
  }
}
