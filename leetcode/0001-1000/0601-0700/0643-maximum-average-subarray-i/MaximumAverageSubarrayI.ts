function findMaxAverage(numbers: number[], k: number): number {
  const { max } = numbers.reduce(
    (accumulated, currentValue, currentIndex) => {
      let { max, sum } = accumulated;

      sum += currentValue;

      if (currentIndex >= k) {
        sum -= numbers[currentIndex - k];
      }

      if (currentIndex >= k - 1) {
        max = Math.max(max, sum);
      }

      return { sum, max };
    },
    {
      sum: 0,
      max: Number.NEGATIVE_INFINITY
    }
  )

  return max / k;
};

console.log(findMaxAverage([1, 12, -5, -6, 50, 3], 4))
