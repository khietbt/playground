function longestOnes(numbers: number[], k: number): number {
  let right = 0;
  let left = 0
  let length = numbers.length;

  while (right < length) {
    k -= 1 - numbers[right++];

    if (k < 0) {
      k += 1 - numbers[left];
      left++;
    }
  }

  return right - left;
};

console.log(longestOnes([1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2))
