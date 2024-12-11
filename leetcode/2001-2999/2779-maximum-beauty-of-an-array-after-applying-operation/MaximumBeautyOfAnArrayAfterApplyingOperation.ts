function maximumBeauty(nums: number[], k: number): number {
  const differences: number[] = new Array(Math.max(...nums) + 2 * k + 2).fill(0);

  nums.forEach(n => {
    differences[n]++;
    differences[n + 2 * k + 1]--;
  });

  let max = 0;
  let sum = 0;

  for (const difference of differences) {
    sum += difference;
    max = Math.max(max, sum);
  }

  return max;
}

const nums: number[] = [4, 6, 1, 2];
const k: number = 2;

console.log(maximumBeauty(nums, k));
