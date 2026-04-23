import java.util.ArrayList;

public class ReverseNodesInKGroup {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.reverseKGroup(
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5,
                            new ListNode(6)))))),
        2));

    System.out.println(solution.reverseKGroup(
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5,
                            new ListNode(6)))))),
        3));
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
    var sb = new StringBuilder("[" + val);

    var c = next;

    while (c != null) {
      sb.append(" --> " + c.val);

      c = c.next;
    }

    return sb.append("]").toString();
  }
}

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    var t = new ListNode();
    var node = t;

    while (head != null) {
      var l = new ArrayList<ListNode>();

      while (head != null && l.size() < k) {
        l.add(head);
        head = head.next;
      }

      if (l.size() == 0) {
        break;
      } else if (l.size() < k) {
        node.next = l.get(0);
      } else {
        while (l.size() > 0) {
          node.next = l.remove(l.size() - 1);
          node = node.next;
          node.next = null;
        }
      }
    }

    // node.next = null;

    return t.next;
  }
}
