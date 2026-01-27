# [3650. Minimum Cost Path with Edge Reversals](https://leetcode.com/problems/minimum-cost-path-with-edge-reversals)

You are given a directed, weighted graph with `n` nodes labeled from 0 to
`n - 1`, and an array `edges` where `edges[i] = [u$_i$, v$_i$, w$_i$]`
represents a directed edge from node `u$_i$` to node `v$_i$` with cost `w$_i$`.

Each node `u$_i$` has a switch that can be used **at most once:** when you
arrive at `u$_i$` and have not yet used its switch, you may activate it on one
of its incoming edges `v$_i$ -> u$_i$` reverse that edge to `u$_i$ -> v$_i$` and
**immediately** traverse it.

The reversal is only valid for that single move, and using a reversed edge costs
`2 * w$_i$`.

Return the **minimum** total cost to travel from node 0 to node `n - 1`. If it
is not possible, return -1.

**Example 1:**

> **Input:**
>
> - `n = 4`
> - `edges = [[0, 1, 3], [3, 1, 1], [2, 3, 4], [0, 2, 2]]`
>
> **Output:** 5
>
> **Explanation:**
>
> ![3650-1](./3650-1.png)
>
> - Use the path `0 -> 1` (cost 3).
> - At node 1, reverse the original edge `3 -> 1` into `1 -> 3` and traverse it
>   at cost `2 * 1 = 2`.
> - Total cost is `3 + 2 = 5`.

**Example 2:**

> **Input:**
>
> - `n = 4`
> - `edges = [[0, 2, 1], [2, 1, 1], [1, 3, 1], [2, 3, 3]]`
>
> **Output:** 3
>
> **Explanation:**
>
> - No reversal is needed. Take the path `0 -> 2` (cost 1), then `2 -> 1`
>   (cost 1).
> - Total cost is `1 + 1 + 1 = 3`.

**Constraints:**

- `2 <= n <= 5 * 10$^4$`
- `1 <= edges.length <= 10$^5$`
- `edges[i] = [u$_i$, v$_i$, w$_i$]`
- `0 <= u$_i$, v$_i$ <= n - 1`
- `1 <= w$_i$ <= 1000`
