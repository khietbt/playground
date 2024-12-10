function visit(grid: string[][], i: number, j: number): void {
  if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] === "0") {
    return;
  }

  grid[i][j] = "0";

  visit(grid, i, j + 1);
  visit(grid, i + 1, j);
  visit(grid, i - 1, j);
  visit(grid, i, j - 1);
}

function numIslands(grid: string[][]): number {
  let totalIslands = 0;

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === "0") {
        continue;
      }

      visit(grid, i, j);

      totalIslands++;
    }
  }

  return totalIslands;
}

const grid = [["1", "1", "0", "0", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "1", "0", "0"], ["0", "0", "0", "1", "1"]];

console.log(numIslands(grid));
