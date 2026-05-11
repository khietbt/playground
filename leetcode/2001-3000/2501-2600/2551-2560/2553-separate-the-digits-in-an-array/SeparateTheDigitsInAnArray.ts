function separateDigits(nums: number[]): number[] {
  const digits: number[] = [];

  for (let i = nums.length - 1; i >= 0; i--) {
    let n = nums[i];

    do {
      digits.push(n % 10);
      n = Math.floor(n / 10);
    } while (n > 0);
  }

  digits.reverse();

  return digits;
}
