function romanToInt(s: string): number {
  const symbols = {
    "M": 1000,
    "D": 500,
    "C": 100,
    "L": 50,
    "X": 10,
    "V": 5,
    "I": 1,
  };

  let value = 0;

  for (let i = 0; i < s.length; i++) {
    if (i < s.length - 1 && symbols[s[i]] < symbols[s[i + 1]]) {
      value += symbols[s[i + 1]] - symbols[s[i]];
      i++;
    } else {
      value += symbols[s[i]];
    }
  }

  return value;
};

console.log(romanToInt("III"));
console.log(romanToInt("XXIX"));
