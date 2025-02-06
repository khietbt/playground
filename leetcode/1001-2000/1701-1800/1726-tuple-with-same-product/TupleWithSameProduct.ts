function tupleSameProduct(numbers: number[]): number {
  const m: Map<number, number> = new Map<number, number>();
  let tuples = 0;

  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      const product = numbers[i] * numbers[j];

      m.set(product, (m.get(product) ?? 0) + 1);
      tuples *= 8;
    }
  }

  return tuples;
};

console.log(tupleSameProduct([1, 2, 4, 5, 10]));
