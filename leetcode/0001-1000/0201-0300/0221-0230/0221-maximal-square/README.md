# [221. Maximal Square](https://leetcode.com/problems/maximal-square)

Given an `m x n` binary `matrix` filled with `0`'s and `1`'s, _find the largest
square containing only `1`'s and return its area_.

**Example 1:**

![0221-1](./0221-1.jpg)

> **Input:**
>
> - `matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"],
["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]`
>
> **Output:** 4

**Example 2:**

![0221-2](./0221-2.jpg)

> **Input:**
>
> - `matrix = [["0", "1"], ["1", "0"]]`
>
> **Output:** 0

**Constraints:**

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 300`
- `matrix[i][j]` is `'0'` or `'1'`
