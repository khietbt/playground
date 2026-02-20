# [401. Binary Watch](https://leetcode.com/problems/binary-watch)

A binary watch has 4 LEDs on the top to represent the hour (0-11), and 6 LEDs on
the bottom to represent the minutes (0-59). Each LED represents a zero or one,
with the least significant bit on the right.

- For example, the below binary watch read "4:51".

![0401-1](./0401-1.jpg)

Given an integer `turnedOn` which represents the number of LEDs that are
currently on (ignoring the PM). Return _all possible times the watch could
represent_. You may return the answer in **any order**.

The hour must not contain a leading zero.

- For example, `"01:00"` is invalid. It should be `"1:00"`.

The minute must consist two digits and my contain a leading zero.

- For example, `"10:2"` is invalid, it should be `"10:02"`.

**Example 1:**

> **Input:**
>
> - `turnedOn = 1`
>
> **Output:** `["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]`

**Example 2:**

> **Input:**
>
> - `turnedOn = 9`
>
> **Output:** \[].

**Constraints:**

- `0 <= turnedOn <= 10`
