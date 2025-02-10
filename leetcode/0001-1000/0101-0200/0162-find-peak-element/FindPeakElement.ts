function findPeakElement(nums: number[]): number {
  const n = nums.length;

  if (n === 1) {
    return 0;
  }

  if (nums[0] > nums[1]) {
    return 0;
  }

  if (nums[n - 1] > nums[n - 2]) {
    return n - 1;
  }

  let left = 1;
  let right = n - 2;

  while (left <= right) {
    const mid = left + ((right - left) >> 1);

    if (nums[mid] > nums[mid - 1] && nums[mid + 1] < nums[mid]) {
      return mid;
    }

    if (nums[mid + 1] > nums[mid]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return 0;
};

console.log(findPeakElement([1, 2, 1, 3, 5, 6, 4]));
