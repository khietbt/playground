function reverseVowels(s: string): string {
  const isVowel = (c: string): boolean => "aeouiAEOUI".indexOf(c) >= 0;
  const characters = s.split("");

  for (let left = 0, right = s.length - 1; left < right; left++, right--) {
    while (left < right && !isVowel(characters[left])) {
      left++;
    }

    while (left < right && !isVowel(characters[right])) {
      right--;
    }

    [characters[left], characters[right]] = [characters[right], characters[left]];
  }

  return characters.join("");
};

console.log(reverseVowels("leetcode"));
console.log(reverseVowels("IceCreAm"));
