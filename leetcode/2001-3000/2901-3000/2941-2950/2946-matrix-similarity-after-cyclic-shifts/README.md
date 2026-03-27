# [2946. Matrix Similarity After Cyclic Shifts](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts)

You are given an `m x n` integer matrix `mat` and an integer `k`. The matrix
rows are 0-indexed.

The following process happens `k` times:

- **Even-indexed** rows (0, 2, 4...) are cyclically shifted to the left.

  ![2946-1](./2946-1.jpg)

- **Odd-indexed** rows (1, 3, 5, 7...) are cyclically shifted to the right;

![2946-2](./2946-2.jpg)

Return `true` if the final modified matrix after `k` steps is identical to the
original matrix, and `false` otherwise.

**Example 1:**

**Input:**
