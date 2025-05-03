function isArraySpecial(nums: number[]): boolean {
  let previous = nums[0] % 2;

  for (let i = 1; i < nums.length; i++) {
    const current = nums[i] % 2;

    if (previous === current) {
      return false;
    }

    previous = current;
  }

  return true;
};

console.log(isArraySpecial([4, 3, 1, 6]));
