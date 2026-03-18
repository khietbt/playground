# [3070. Count Submatrices with Top-Left Element and Sum Less Than k](https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k)

You are given a **0-indexed** integer matrix `grid` and an integer `k`.

Return _the **number** of submatrices that contain the top-left element of the
`grid`, and have a sum less than or equal to `k`_.

**Example 1:**

![3070-1](./3070-1.png)

> **Input:**
>
> - `grid = [[7, 6, 3], [6, 6, 1]]`
> - `k = 18`
>
> **Output:** 4
>
> **Explanation:** There are only 4 submatrices, shown in the image above, that
> contain the top-left element of grid, and have a sum less than or equal to 18.

**Example 2:**

![3070-2](./3070-2.png)

> **Input:**
>
> - `grid = [[7, 2, 9], [1, 5, 0], [2, 6, 6]]`
> - `k = 20`
>
> **Output:** 6
>
> **Explanation:** There are only 6 submatrices, shown in the image above, that
> contain the top-left element of grid, and have a sum less than or equal to 20.

**Constraints:**

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 1000`
- `0 <= grid[i][j] <= 1000`
- `1 <= k <= 10$^9$`
