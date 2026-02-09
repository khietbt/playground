# [1382. Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree)

Given the `root` of a binary search tree, return _a **balanced** binary search
tree with the same node values_. If there is more than one answer, return **any
of them**.

A binary search tree is **balanced** if the depth of 2 subtrees of every node
never differs more than `1`.

**Example 1:**

![1382-1](./1382-1.jpg)

> **Input:**
>
> - `root = [1, null, 2, null, 3, null, 4, null, null]`
>
> **Output:** `[2, 1, 3, null, null, null, 4]`
>
> **Explanation:** This is not the only correct answer, `[3, 1, 4, null, 2]` is
> also correct.

**Example 2:**

![1382-2](./1382-2.jpg)

> **Input:**
>
> - `root = [2, 1, 3]`
>
> **Output:** `[2, 1, 3]`

**Constraints:**

- The number of nodes in the tree in the range `[1, 10$^4$]`
- `1 <= node.val <= 10$^5$`
