function longestSubarray(numbers: number[]): number {
  let length = numbers.length;

  if (length < 2) {
    return 0;
  }

  let left = 0;
  let right = 0;
  let numberOfZeros = 0;

  while (right < length) {
    if (numbers[right++] === 0) {
      numberOfZeros++;
    }

    if (numberOfZeros > 1) {
      if (numbers[left++] === 0) {
        numberOfZeros--;
      }
    }
  }

  return right - left - 1;
};

console.log(longestSubarray([0, 1, 1, 1, 0, 1, 1, 0, 1]));
