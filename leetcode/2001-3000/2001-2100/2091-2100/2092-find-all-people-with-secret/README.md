# [2092. Find All People With Secret](https://leetcode.com/problems/find-all-people-with-secret)

You are given an integer `n` indicating `n` people numbered from `0` to `n - 1`.
You are also given a **0-indexed** 2D integer array `meetings` where
`meetings[i] = [x$_i$, y$_i$, time$_i$]` indicates that person `x$_i$` and
person `y$_i$` having a meeting at `time$_i$`. A person may attend **multiple
meetings** at the same time. Finally, you are given an integer `firstPerson`.

Person `0` has a **secret** and initially shares the secret with a person
`firstPerson` at time `0`. This secret is then shared every time a meeting takes
place with a person that has the secret. More formally, for every meeting, if a
person `x$_i$` has the secret at `time$_i$`, then he will share the secret with
person `y$_i$` and vice versa.

The secretes are shared **instantaneously**. That is, a person may receive the
secrete and `time$_i$`, then share it with people in other meetings within the same
time frame.

Return _a list of all the people that have the secret after all meetings have taken
place_. You may return the answer in **any order**.

**Example 1:**

> **Input:**
>
> - `n = 6`
> - `meetings = [[1, 2, 5], [2, 3, 8], [1, 5, 10]]`
> - `firstPerson = 1`
>
> **Output:** `[0, 1, 2, 3, 5]`
>
> **Explanation:**
>
> - At time 0, person 0 shares the secret with person 1.
> - At time 5, person 1 shares the secret with person 2.
> - At time 8, person 2 shares the secret with person 3.
> - At time 10, person 3 shares the secret with person 4.
>
> Thus, people `[0, 1, 2, 3, 5]` know the secret after all the meetings.

**Example 2:**

> **Input:**
>
> - `n = 4`
> - `meetings = [[3, 1, 3], [1, 2, 2], [0, 3, 3]]`
> - `firstPerson = 3`
>
> **Output:** `[0, 1, 3]`
>
> **Explanation:**
>
> - At time 0, person 0 shares the secret with person 3.
> - At time 2, neither person 1 & person 2 know the secret.
> - At time 3, person 3 shares the secret with person 1.
>
> Thus, people `[0, 1, 3]` know the secret after all the meetings.

**Example 3:**

> **Input:**
>
> - `n = 5`
> - `meetings = [[3, 4, 2], [1, 2, 1], [2, 3, 1]]`
> - `firstPerson = 1`
>
> **Output:** `[0, 1, 2, 3, 4]`
>
> **Explanation:**
>
> - At time 0, person 0 shares the secret with person 1.
> - At time 1, person 1 shares the secret with person 2, and person 2 shares the
>   secret with person 3.
>   Note that person 2 can share the secret at the same time as receiving it.
> - At time 2, person 3 shares the secret with person 4.
>
> Thus, people `[0, 1, 2, 3, 4]` know the secret after all the meetings.

**Constraints:**

- `2 <= n <= 10$^5$`
- `1 <= meetings.length <= 10$^5$`
- `meetings[i].length == 3`
- `0 <= x$_i$, y$_i$ <= n - 1`
- `x$_i$ != y$_i$`
- `1 <= time$_i$ <= 10$_5$`
- `1 <= firstPerson <= n - 1`
