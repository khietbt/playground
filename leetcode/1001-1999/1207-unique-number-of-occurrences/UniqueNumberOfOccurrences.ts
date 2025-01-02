function uniqueOccurrences(numbers: number[]): boolean {
  const m = numbers.reduce(
    (accumulated, currentValue) => {
      accumulated[currentValue] = (accumulated[currentValue] ?? 0) + 1;

      return accumulated;
    },
    {}
  );

  const values = Object.values(m);
  const uniqueOccurrences = new Set(values);

  return values.length === uniqueOccurrences.size;
};

console.log(uniqueOccurrences([-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]))
