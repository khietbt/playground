public class MergeTwoSortedLists {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.mergeTwoLists(
        new ListNode(1, new ListNode(2, new ListNode(4))),
        new ListNode(1, new ListNode(3, new ListNode(4)))));

    System.out.println(solution.mergeTwoLists(
        null,
        new ListNode(1, new ListNode(3, new ListNode(4)))));

    System.out.println(solution.mergeTwoLists(
        new ListNode(1, new ListNode(2, new ListNode(4))),
        null));

    System.out.println(solution.mergeTwoLists(null, null));
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
    var sb = new StringBuilder("[");

    sb.append(val);

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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var head = new ListNode();
    var node = head;

    while (list1 != null || list2 != null) {
      if (list1 == null) {
        node.next = list2;
        break;
      } else if (list2 == null) {
        node.next = list1;
        break;
      } else {
        //
        if (list1.val > list2.val) {
          //
          node.next = list2;
          list2 = list2.next;
        } else {
          node.next = list1;
          list1 = list1.next;
          //
        }

        node = node.next;
        node.next = null;
      }
    }

    return head.next;
  }
}
