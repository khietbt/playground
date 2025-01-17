function tribonacci(n: number): number {
  if (n === 0) {
    return 0;
  }

  if (n === 1) {
    return 1;
  }

  if (n === 2) {
    return 1;
  }

  let t0 = 0;
  let t1 = 1;
  let t2 = 1;

  let t = 0;
  while (n-- > 2) {
    t = t0 + t1 + t2;
    t0 = t1;
    t1 = t2;
    t2 = t
  }

  return t2;
};

console.log(tribonacci(25));
