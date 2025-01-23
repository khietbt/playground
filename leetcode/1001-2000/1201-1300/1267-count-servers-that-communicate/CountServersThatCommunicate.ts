function countServers(grid: number[][]): number {
  const m = grid.length;
  const n = grid[0].length;

  const columns = new Array(n).fill(0);
  const rows = new Array(m).fill(0);

  grid.forEach((row, i) => {
    row.forEach((cell, j) => {
      if (cell === 1) {
        rows[i]++;
        columns[j]++;
      }
    });
  });

  let servers = 0;

  grid.forEach((row, i) => {
    row.forEach((cell, j) => {
      if (cell === 1 && (rows[i] > 1 || columns[j] > 1)) {
        servers++;
      }
    });
  });

  return servers;
};

console.log(countServers([[1, 1, 0, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 1]]));
