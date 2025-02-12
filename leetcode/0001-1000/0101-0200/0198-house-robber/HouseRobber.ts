function rob(nums: number[]): number {
  let [previous, current] = [0, 0];

  for (const num of nums) {
    [previous, current] = [Math.max(previous, current), previous + num];
  }

  return Math.max(previous, current);
};

console.log(rob([2, 7, 9, 6, 1]));

// 1 2 3 4 5 6 7 8 9
//
// x   x   x   x   x
// x   x   x     x  
// x   x     x   x  
// x   x     x     x
//
//
// x     x   x   x
// x     x   x     x
// x     x     x   x
