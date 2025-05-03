function check(nums: number[]): boolean {
  const n = nums.length;

  if (n < 3) {
    return true;
  }

  let i = 1;

  while (i < n) {
    if (nums[i] < nums[i - 1]) {
      break;
    }

    i++;
  }

  if (i === n) {
    return true;
  }

  i++;

  while (i < n) {
    if (nums[i] < nums[i - 1]) {
      return false;
    }

    i++;
  }

  return nums[n - 1] <= nums[0];
};

console.log(check([3, 4, 5, 1, 2]));
console.log(check([2, 1, 3, 4]));


