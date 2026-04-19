import java.util.PriorityQueue;

public class MergeKSortedLists {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.mergeKLists(
            new ListNode[] {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
            }));
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
  public ListNode mergeKLists(ListNode[] lists) {
    var head = new ListNode();
    var current = head;

    var queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> {
      return a.val - b.val;
    });

    for (var node : lists) {
      queue.offer(node);
    }

    while (!queue.isEmpty()) {
      var node = queue.poll();
      var next = node.next;
      node.next = null;
      current.next = node;
      current = current.next;

      if (next != null) {
        queue.offer(next);
      }
      //
    }

    return head.next;
  }
}
