function isArraySpecial(nums: number[], queries: number[][]): boolean[] {
  const specials: number[] = new Array(nums.length);

  specials[0] = 0;

  for (let i = 1; i < nums.length; i++) {
    if (nums[i] % 2 !== nums[i - 1] % 2) {
      specials[i] = specials[i - 1];
      continue;
    }

    specials[i] = i;

  }

  return queries.map(q => specials[q[1]] <= specials[q[0]]);
}


// Testcases
const nums = [3, 4, 1, 2, 6];
const queries = [[0, 1]];
// const queries = [[0, 4]];

console.log(isArraySpecial(nums, queries));
