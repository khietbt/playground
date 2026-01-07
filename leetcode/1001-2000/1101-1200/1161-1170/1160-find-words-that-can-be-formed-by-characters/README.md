# [1160. Find Words That Can Be Formed by Characters](https://leetcode.com/problems/find-words-that-can-be-formed-by-characters)

You are given an array of strings `wors` and a string `chars`.

A string is **good** if it can be formed by characters from `chars` (each
character can only be used once for **each** word in `words`).

Return _the sum of lengths of all good strings in words_.

**Example 1:**

> **Input:**
>
> - `words = ["cat", "bt", "hat", "tree"]`
> - `chars = "atach"`
>
> **Output:** 10
>
> **Explanation:** The strings that can be formed are "hello" and "world" so the
> answer is 5 + 5 = 10.

**Constraints:**

- `1 <= words.length <= 1000`
- `1 <= words[i].length, chars.length <= 100`
- `words[i]` and `chars` consist of lowercase English letters.
