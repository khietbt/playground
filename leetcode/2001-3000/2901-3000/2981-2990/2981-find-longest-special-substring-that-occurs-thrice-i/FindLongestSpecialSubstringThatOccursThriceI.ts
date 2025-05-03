function maximumLength(s: string): number {
  let left = 0;
  let right = s.length;
  let length = s.length;

  const hasSubstring = (size: number): boolean => {
    let i: number = 0;
    let j: number = 0;
    const repeats = {};

    while (i < length) {

      while (j < length && s[j] === s[j - 1]) {
        j++;
      }

      // Number of times
      const times = Math.max(0, j - i - size + 1);
      repeats[s[i]] = (repeats[s[i]] ?? 0) + times;

      if (repeats[s[i]] >= 3) {
        return true;
      }

      // Preparation for the next round
      i = j;
      j = i + 1;
    }

    return false;
  }

  while (left < right) {
    const middle: number = (left + right + 1) >> 1;

    if (hasSubstring(middle)) {
      left = middle;
    } else {
      right = middle - 1;
    }
  }

  return left === 0 ? -1 : left;
};

const s: string = "ahohhhvggh";
// const s: string = "abcdefabcdefaabbccddeeffaaabbbdaaaa";
// const s = "aaaa";

console.log(maximumLength(s));

