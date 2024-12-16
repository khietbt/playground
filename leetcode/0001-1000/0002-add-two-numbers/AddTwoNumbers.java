public class AddTwoNumbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));

    ListNode result = (new Solution()).addTwoNumbers(l1, l2);

    while (result != null) {
      System.out.println(result.val);
      result = result.next;
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int additional = 0;

    ListNode n = new ListNode();
    ListNode node = n;

    while (l1 != null || l2 != null) {
      int sum = additional;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      additional = sum / 10;

      n.next = new ListNode(sum % 10);
      n = n.next;
    }

    if (additional != 0) {
      n.next = new ListNode(additional);
    }

    return node.next;
  }
}
