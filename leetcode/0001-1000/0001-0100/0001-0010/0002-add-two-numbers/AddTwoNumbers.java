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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;

    var node = new ListNode();
    var current = node;

    while (l1 != null || l2 != null) {
      int v = carry;

      if (l1 != null) {
        v += l1.val;

        l1 = l1.next;
      }

      if (l2 != null) {
        v += l2.val;
        l2 = l2.next;
      }

      carry = v / 10;
      v = v % 10;

      current.next = new ListNode(v);

      current = current.next;
    }

    if (carry > 0) {
      current.next = new ListNode(carry);
    }

    return node.next;
  }
}
