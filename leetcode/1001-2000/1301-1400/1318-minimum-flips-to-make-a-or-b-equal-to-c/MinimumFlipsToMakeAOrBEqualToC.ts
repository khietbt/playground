function minFlips(a: number, b: number, c: number): number {
  let flips = 0;

  while (a !== 0 && b !== 0 && c !== 0) {
    const x = a & 1;
    const y = b & 1;
    const z = c & 1;

    if ((x | y) !== z) {
      flips += (x === 1 && y === 1) ? 2 : 1;
    }

    // Next round
    a >>= 1;
    b >>= 1;
    c >>= 1;
  }

  return flips;
};


console.log(minFlips(2, 6, 5));
