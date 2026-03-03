# [1545. Find Kth Bit in Nth Binary String](https://leetcode.com/problems/find-kth-bit-in-nth-binary-string)

Given two positive integers `n` and `k`, the binary string `S$_n$` is formed as
follows:

- `S$_1$ = "0"`
- `S$_i$ = S$_i-1$ + "1" + reverse(invert(S$_i-1$))` for `i> 1`

Where `+` denotes the concatenation operation, `reverse(x)` returns the reversed
string `x`, and `invert(x)` inverts all the bits in `x` (`0` changes to `1` and
`1` to `0`).

For example, the first four strings in the above sequence are:

- `S$_1$ = "0"`
- `S$_2$ = "011"`
- `S$_3$ = "0111001"`
- `S$_4$ = "011100110110001"`

Return _the `k$^th` bit in `S$_n$`_. It is guaranteed is valid for the given `n`.

**Example 1:**

> **Input:**
>
> - `n = 3`
> - `k = 1`
>
> **Output:** "0"
>
> **Explanation:** S$_3$ is "0111001".
>
> The 1$^st$ bit is "0".

**Example 2:**

> **Input:**
>
> - `n = 4`
> - `k = 11`
>
> **Output:** "1"
>
> **Explanation:** S$_4$ is "011100110110001";
>
> The 11$^th$ bit is "1".

**Constraints:**

- `1 <= n <= 20`
- `1 <= k <= 2$^n$ - 1`
