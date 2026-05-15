function findMin(nums: number[]): number {
  const n = nums.length;
  let l = 0;
  let r = n - 1;
  const threshold = nums[n - 1];

  while (l < r) {
    if (nums[l] <= nums[r]) {
      return nums[l];
    }

    const m = l + ((r - l) >> 1);

    if (nums[m] > threshold) {
      l = m + 1;
    } else {
      r = m;
    }
  }

  return nums[l];
};

console.log(findMin([6]));
console.log(findMin([6, 7]));
console.log(findMin([6, 7, 5]));
console.log(findMin([6, 7, 4, 5]));
console.log(findMin([6, 7, 3, 4, 5]));
console.log(findMin([6, 7, 2, 3, 4, 5]));
console.log(findMin([6, 7, 1, 2, 3, 4, 5]));
console.log(findMin([6, 7, 0]));
