function maxAscendingSum(numbers: number[]): number {
  if (numbers.length === 0) {
    return 0;
  }

  let sum = numbers[0];
  let max = numbers[0];

  for (let i = 1; i < numbers.length; i++) {
    if (numbers[i] > numbers[i - 1]) {
      sum += numbers[i];
    } else {
      sum = numbers[i];
    }

    max = Math.max(max, sum);
  }

  return max;
};

console.log(maxAscendingSum([12, 17, 15, 13, 10, 11, 12]));
console.log(maxAscendingSum([10, 20, 30, 5, 10, 50]));
