function canBeValid(s: string, locked: string): boolean {
  if (s.length % 2 === 1) {
    return false;
  }

  let left = 0;
  let right = 0;

  for (let i = 0; i < s.length; i++) {
    if (locked[i] === "0") {
      left++;
      right++;
    } else {
      if (s[i] === "(") {
        left++;
      } else {
        left--;
      }

      if (s[s.length - 1 - i] === ")") {
        right++;
      } else {
        right--;
      }

      if (left < 0 || right < 0) {
        return false;
      }
    }
  }

  return true;
};

console.log(canBeValid("))()))", "010100"))
