function longestMonotonicSubarray(nums: number[]): number {
  let max = 1;
  let currentLength = 1;
  const n = nums.length;

  for (let i = 1; i < n; i++) {
    if (nums[i] > nums[i - 1]) {
      currentLength++;

      max = Math.max(currentLength, max);
    } else {
      currentLength = 1;
    }
  }

  currentLength = 1;

  for (let i = 1; i < n; i++) {
    if (nums[i] < nums[i - 1]) {
      currentLength++;

      max = Math.max(currentLength, max);
    } else {
      currentLength = 1;
    }
  }

  return max;
};

// console.log(longestMonotonicSubarray([1, 4, 3, 3, 2]));
console.log(longestMonotonicSubarray([2, 1, 10]));

