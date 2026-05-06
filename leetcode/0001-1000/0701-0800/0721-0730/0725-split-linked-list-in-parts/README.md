# [725. Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts)

Given the `head` of a singly linked list and an integer `k`, split the linked
list into `k` consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have
a size differing by more than one. This may lead to some parts being null.

**Example 1:**

![0725-1](./0725-1.jpg)

> **Input:**
>
> - `head = [1, 2, 3]`
> - `k = 5`
>
> **Output:** `[[1], [2], [3], [], []]`
>
> **Explanation:**
>
> - The first element output\[0] has output\[0].val = 1, output\[0].next = null.
> - The last element output\[4] is null, but its string representation as a
>   ListNode is \[].

**Example 2:**

![0725-2](./0725-2.jpg)

> **Input:**
>
> - `head = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`
> - `k = 3`
>
> **Output:** `[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]`
>
> **Explanation:** The input has been split into consecutive parts with size
> difference at most 1, and earlier parts are a larger than the later parts.

**Constraints:**

- The number of nodes in the list is in the range `[0, 1000]`.
- `0 <= node.val <= 1000`
- `1 <= k <= 50`
