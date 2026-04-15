# [72. Edit Distance](https://leetcode.com/problems/edit-distance)

Given two strings `word1` and `word2`, return _the minimum number of operations
required to convert `word1` to `word2`_.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

**Example 1:**

> **Input:**
>
> - `word1 = "horse"`
> - `word2 = "ros"`
>
> **Output:** 3
>
> **Explanation:**
>
> 1. horse -> rorse (replace 'h' by 'r')
> 2. rorse -> rose (remove 'r')
> 3. rose -> ros (remove 'e')

**Example 2:**

> **Input:**
>
> - `word1 = "intention`
> - `word2 = execution`
>
> **Output:** 5
>
> **Explanation:**
>
> 1. intention -> inention (remove 't')
> 2. inention -> enention (replace 'i' with 'e')
> 3. enention -> exention (replace 'n' with 'x')
> 4. exention -> exection (replace 'n' with 'c')
> 5. exection -> execution (insert 'u')

**Constraints:**

- `0 <= word1.length, word2.length <= 500`
- `word1` and `word2` consist of lowercase English letters.
