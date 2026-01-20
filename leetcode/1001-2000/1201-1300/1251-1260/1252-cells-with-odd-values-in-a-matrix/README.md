# [1252. Cells with Odd Values in a Matrix](https://leetcode.com/problems/cells-with-odd-values-in-a-matrix)

There is an `m x n` matrix that is initialized to all `0`'s. There is also a 2D
array `indices` where each `indices[i] = [r$_i$, c$_i$]` represents a
**0-indexed location** to perform some increment operations on the matrix.

For each location `indices[i]`, do **both** of the following:

1. Increment **all** the cells on row `r$_i$`.
2. Increment **all** the cells on column `c$_i$`.

Given `m`, `n` and `indices`, return _the **number of odd-valued cells** in the
matrix after applying the increment to all locations in `indices`_.

**Example 1:**

![1252-1](./1252-1.png)

> **Input:**
>
> - `m = 2`
> - `n = 3`
> - `indices = [[0, 1], [1, 1]]`
>
> **Output:** 6
>
> **Explanation:** Initial matrix = `[[0, 0, 0], [0, 0, 0]]`.
>
> After applying first increment it becomes `[[1, 2, 1], [0, 1, 0]]`.
>
> The final matrix is `[[1, 3, 1], [1, 3, 1]]`, which contains 6 odd numbers.

**Example 2:**

![1252-2](./1252-2.png)

> **Input:**
>
> - `m = 2`
> - `n = 2`
> - `indices = [[1, 1], [0, 0]]`
>
> **Output:** 0
>
> **Explanation:** Final matrix = `[[2, 2], [2, 2]]`. There are no odd numbers
> in the final matrix.

**Constraints:**

- `1 <= m, n <= 50`
- `1 <= indices.length <= 100`
- `0 <= r$_i$ < m`
- `0 <= c$_i$ < n`

**Follow up:** Could you solve this in `O(n + m + indices.length)` time with
only `O(n + m)` extra space?
