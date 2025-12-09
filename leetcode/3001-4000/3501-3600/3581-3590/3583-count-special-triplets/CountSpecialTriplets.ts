function specialTriplets(nums: number[]): number {
  const limit = 100_001;

  const left: number[] = new Array(limit).fill(0);
  const right: number[] = new Array(limit).fill(0);
  const modulo = 1_000_000_007;

  for (const n of nums) {
    right[n]++;
  }

  let totalTriplets = 0;

  for (const n of nums) {
    right[n]--;

    const l = (n * 2 > limit) ? right[n * 2]: 0;
    const r = (n * 2 > limit) ? left[n * 2]: 0;
    const t = (l * r) % modulo;

    totalTriplets = (totalTriplets + t) % modulo;

    left[n]++;
  }

  return totalTriplets;
};

console.log(specialTriplets([2, 1, 2]));
console.log(specialTriplets([8, 4, 2, 8, 4]));
console.log(specialTriplets([0, 1, 0, 0]));

