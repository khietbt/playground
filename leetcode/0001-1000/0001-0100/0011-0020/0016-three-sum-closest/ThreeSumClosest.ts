function threeSumClosest(numbers: number[], target: number): number {
  const n = numbers.length;

  let minDiff = Number.MAX_VALUE;
  let min = Number.MAX_VALUE;

  numbers.sort((a, b) => a - b);

  for (let i = 0; i < n - 2; i++) {
    const first = numbers[i];

    let j = i + 1;
    let k = n - 1;

    while (j < k) {
      const second = numbers[j];
      const third = numbers[k];

      const sum = first + second + third;

      const diff = Math.abs(sum - target);

      if (diff < minDiff) {
        minDiff = diff;
        min = sum;
      }

      if (sum < target) {
        j++;
      } else if (sum > target) {
        k--;
      } else {
        return target;
      }
    }
  }

  return min;
};

console.log(threeSumClosest([-1, 2, 1, -4], 1));
