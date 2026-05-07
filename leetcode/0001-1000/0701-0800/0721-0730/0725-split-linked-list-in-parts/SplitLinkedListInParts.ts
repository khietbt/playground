class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }

  public toString(): string {
    return "val = " + this.val;
  }
}

function splitListToParts(
  head: ListNode | null,
  k: number,
): [ListNode | null][] {
  const answer: [ListNode | null][] = new Array(k).fill(null);

  if (head == null) {
    return answer;
  }

  let node: ListNode | null = head;
  let n = 0;

  while (node != null) {
    node = node.next;
    n++;
  }

  console.log(n);

  return answer;
}

console.log(
  splitListToParts(
    new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          3,
          new ListNode(
            4,
            new ListNode(
              5,
              new ListNode(
                6,
                new ListNode(
                  7,
                  new ListNode(8, new ListNode(9, new ListNode(10))),
                ),
              ),
            ),
          ),
        ),
      ),
    ),
    3,
  ),
);
