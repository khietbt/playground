function minFlips(s: string): number {
  let minimum = Number.MAX_SAFE_INTEGER;
  const minimums = [0, 0];

  for (let i = 0; i < s.length; i++) {
    minimums[(i ^ s.charCodeAt(i)) & 1]++;
  }

  for (let i = 0; i < s.length; i++) {
    minimums[(i ^ s.charCodeAt(i)) & 1]--;
    minimums[((i + s.length) ^ s.charCodeAt(i)) & 1]++;

    minimum = Math.min(...minimums, minimum);
  }

  return minimum;
}

console.log(minFlips("01001001101"));
// console.log(minFlips("111000"));
// console.log(minFlips("1110"));
