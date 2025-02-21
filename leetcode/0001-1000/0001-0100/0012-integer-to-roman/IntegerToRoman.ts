function intToRoman(num: number): string {
  const values: number[] = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  const symbols: string[] = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];

  let answer: string = "";

  for (let i = 0; i < values.length; i++) {
    while (num > values[i]) {
      num -= values[i];
      answer += symbols[i];
    }
  }

  return answer;
};

console.log(intToRoman(3749));
