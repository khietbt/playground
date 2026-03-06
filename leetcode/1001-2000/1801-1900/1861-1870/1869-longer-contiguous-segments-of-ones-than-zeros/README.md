# [1869. Longer Contiguous Segments of Ones than Zeros](https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros)

Given a binary string `s`, return `true` _if the **longest** contiguous segment
of `1`'s is **strictly longer** than the **longest** contiguous segment of `0`'s
in `s`_, or return `false` _otherwise_.

- For example, in `s = "110100010"`, the longest contiguous segment of `1`s has
  length `2`, and the longest contiguous segment of `0`s has length `3`.

Note that if there are no `0`'s, then the longest contiguous segment of `0`'s is
considered to have a length `0`. The same applies if there is no `1`'s.

**Example 1:**

> **Input:**
>
> - `s = "1101`
>
> **Output:** true
>
> **Explanation:**
>
> - The longest contiguous segment of 1s has length 2: "**11**01".
> - The longest contiguous segment of 0s has length 1: "11**0**1".
>
> The segment of 1s is longer, so return true;

**Example 2:**

> **Input:**
>
> - `s = "111000"`
>
> **Output:** false
>
> **Explanation:**
>
> - The longest contiguous segment of 1s has length 3: "**111**000".
> - The longest contiguous segment of 0s has length 3: "111**000**".
>
> The segment of 1s is not longer, so return false.

**Example 3:**

> **Input:**
>
> - `s = "110100010`
>
> **Output:** false
>
> **Explanation:**
>
> - The longest contiguous segment of 1s has length 2: "**11**0100010".
> - The longest contiguous segment of 0s has length 3: "1101**000**10".
>
> The segment of 1s is not longer, so return false.

**Constraints:**

- `1 <= s.length <= 100`
- `s[i]` is either `'0'` or `'1'`.
