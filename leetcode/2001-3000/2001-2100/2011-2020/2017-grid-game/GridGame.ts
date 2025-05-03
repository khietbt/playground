function gridGame(grid: number[][]): number {
  let left = 0;
  let right = grid[0].reduce((accumulated, value) => accumulated + value, 0);
  let max = Number.MAX_VALUE;

  for (let i = 0; i < grid[0].length; i++) {
    right -= grid[0][i];
    max = Math.min(max, Math.max(left, right));
    left += grid[1][i];
  }

  return max;
};

console.log(gridGame([[1, 3, 1, 15], [1, 3, 3, 1]]))
