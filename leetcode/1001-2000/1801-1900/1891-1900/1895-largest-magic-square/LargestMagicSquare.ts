function largestMagicSquare(grid: number[][]): number {
  const m = grid.length;
  const n = grid[0].length;

  const rowSums = new Array(m).fill(0).map((_) => new Array(n).fill(0));
  const colSums = new Array(m).fill(0).map((_) => new Array(n).fill(0));

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      const v = grid[i][j];

      rowSums[i][j] += (j > 0 ? rowSums[i][j - 1] : 0) + v;
      colSums[i][j] += (i > 0 ? colSums[i - 1][j] : 0) + v;
    }
  }

  const sumRow = (i: number, left: number, right: number) => {
    return rowSums[i][right] - (left > 0 ? rowSums[i][left - 1] : 0);
  };

  const sumColumn = (i: number, top: number, bottom: number) => {
    return colSums[bottom][i] - (top > 0 ? colSums[top - 1][i] : 0);
  };

  const isMagicSquare = (k: number, top: number, left: number) => {
    const bottom = top + k - 1;
    const right = left + k - 1;

    const targetSum = sumRow(top, left, right);

    for (let i = 1; i < k; i++) {
      if (sumRow(top + i, left, right) !== targetSum) {
        return false;
      }
    }

    for (let i = 0; i < k; i++) {
      if (sumColumn(left + i, top, bottom) !== targetSum) {
        return false;
      }
    }

    let diagonal = 0;
    let reversedDiagonal = 0;

    for (let i = 0; i < k; i++) {
      diagonal += grid[top + i][left + i];
      reversedDiagonal += grid[top + k - 1 - i][left + i];
    }

    return diagonal === reversedDiagonal && diagonal === targetSum;
  };

  for (let k = Math.min(m, n); k > 1; k--) {
    for (let top = 0; top <= m - k; top++) {
      for (let left = 0; left <= n - k; left++) {
        if (isMagicSquare(k, top, left)) {
          return k;
        }
      }
    }
  }

  return 1;
}

console.log(
  largestMagicSquare([
    [7, 1, 4, 5, 6],
    [2, 5, 1, 6, 4],
    [1, 5, 4, 3, 2],
    [1, 2, 7, 3, 4],
  ]),
);

console.log(
  largestMagicSquare([
    [5, 1, 3, 3],
    [9, 3, 3, 3],
    [1, 3, 3, 8],
  ]),
);
