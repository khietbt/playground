function minCostClimbingStairs(cost: number[]): number {
  let a = cost[0];
  let b = cost[1];

  for (let i = 2; i < cost.length; i++) {
    const current = cost[i] + Math.min(a, b);
    a = b;
    b = current;
  }

  return Math.min(a, b);
};

console.log(minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]));
