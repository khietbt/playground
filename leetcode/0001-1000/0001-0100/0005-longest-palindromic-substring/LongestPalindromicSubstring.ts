function longestPalindrome(s: string): string {
  const n = s.length
  const m: boolean[][] = new Array(n).fill(0).map(() => new Array(n).fill(true));

  let startIndex = 0;
  let maxLength = 1;

  for (let i = n - 2; i >= 0; i--) {
    for (let j = i + 1; j < n; j++) {
      m[i][j] = false;

      if (s[i] === s[j]) {
        m[i][j] = m[i + 1][j - 1];

        if (m[i][j] && maxLength < j - i + 1) {
          maxLength = j - i + 1;
          startIndex = i;
        }
      }
    }
  }

  return s.substring(startIndex, startIndex + maxLength);
};

console.log(longestPalindrome("abaabd"));
