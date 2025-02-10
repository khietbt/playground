function singleNumber(nums: number[]): number {
  let single = 0;

  for (let i = 0; i < nums.length; i++) {
    single ^= nums[i];
  }

  return single;
};

console.log(singleNumber([4, 1, 2, 1, 2]));
