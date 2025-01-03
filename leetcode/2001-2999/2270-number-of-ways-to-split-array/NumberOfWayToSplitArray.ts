function waysToSplitArray(numbers: number[]): number {
  const accumulated = numbers.reduce(
    (accumulated, currentValue) => {
      accumulated.push(accumulated[accumulated.length - 1] + currentValue);

      return accumulated;
    }, [0]
  );

  let totalValidWays = 0;
  let left = 0;
  let right = 0;

  for (let i = 0; i < numbers.length - 1; i++) {
    left = accumulated[i + 1] - accumulated[0];
    right = accumulated[numbers.length] - accumulated[i + 1];

    if (left >= right) {
      totalValidWays++;
    }
  }

  return totalValidWays;
};

console.log(waysToSplitArray([10, 4, -8, 7]));
console.log(waysToSplitArray([2, 3, 1, 0]));
