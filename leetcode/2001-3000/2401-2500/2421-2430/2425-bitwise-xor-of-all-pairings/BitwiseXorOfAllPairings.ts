function xorAllNums(lhs: number[], rhs: number[]): number {
  let x: number = 0;

  if (lhs.length % 2 === 1) {
    for (const r of rhs) {
      x ^= r;
    }
  }

  if (rhs.length % 2 === 1) {
    for (const l of lhs) {
      x ^= l;
    }
  }

  return x;
};

console.log(xorAllNums([2, 1, 3], [10, 2, 5, 0]))
