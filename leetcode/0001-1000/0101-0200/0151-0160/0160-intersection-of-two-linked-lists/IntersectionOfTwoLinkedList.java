public class IntersectionOfTwoLinkedList {

}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    var pA = headA;
    var pB = headB;

    while (pA != pB) {
      pA = pA == null ? headA : pA.next;
      pB = pB == null ? headB : pB.next;
    }

    return pA;
  }
}
