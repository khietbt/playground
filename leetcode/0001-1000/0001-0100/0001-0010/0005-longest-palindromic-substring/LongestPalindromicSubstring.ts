const longestPalindrome = (s: string): string => {
  if (!s) {
    return "";
  }

  let start = 0;
  let length = 1;

  const palindrome = "#" + s.split("").join("#") + "#";
  const lps: number[] = new Array(palindrome.length).fill(0);

  for (let i = 0; i < palindrome.length; i++) {
    let j = 0;

    while (
      i - j - 1 >= 0 &&
      i + j + 1 < palindrome.length &&
      palindrome[i - j - 1] === palindrome[i + j + 1]
    ) {
      lps[i]++;
      j++;
    }

    if (lps[i] > length) {
      length = lps[i];
      start = i;
    }
  }

  return s.substring((start - length) / 2, (start + length + 1) / 2);
}

console.log(longestPalindrome("bbaabba"));
