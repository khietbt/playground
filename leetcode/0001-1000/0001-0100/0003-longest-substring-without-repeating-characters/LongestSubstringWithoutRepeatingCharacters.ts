function lengthOfLongestSubstring(s: string): number {
  const t = {};

  const { max } = s.split('').reduce(
    (previous, currentCharacter, currentCharacterIndex) => {
      let { max, left } = previous;

      if (t[currentCharacter] !== undefined) {
        while (left <= t[currentCharacter]) {
          t[s[left]] = undefined;
          left++;
        }
      }

      t[currentCharacter] = currentCharacterIndex;

      max = Math.max(max, currentCharacterIndex - left + 1);

      return { max, left };
    }, {
    max: 0,
    left: 0
  });

  return max;
};

console.log(lengthOfLongestSubstring("abcabcab"));
