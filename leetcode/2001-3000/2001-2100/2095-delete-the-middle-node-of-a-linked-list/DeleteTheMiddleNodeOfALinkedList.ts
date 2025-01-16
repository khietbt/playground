class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}

function deleteMiddle(head: ListNode | null): ListNode | null {
  let dummy = new ListNode(0, head);
  let slow = dummy;
  let fast = head;

  while (fast != null && fast.next != null) {
    slow = slow.next!;
    fast = fast.next.next;
  }

  if (slow.next != null) {
    slow.next = slow.next.next;
  }

  return dummy.next;
};
