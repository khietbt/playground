class Island {
  constructor(public id: number, public area: number) { }
}

const directions = [[-1, 0], [0, 1], [1, 0], [0, -1]];

const cell2island = (grid: number[][]): Map<number, Island> => {
  const n = grid.length;
  const islands = new Map();
  const visited: boolean[][] = new Array(n).fill(false).map(
    (_) => new Array(n).fill(false)
  );

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (visited[i][j]) {
        continue;
      }

      if (grid[i][j] === 0) {
        visited[i][j] = true;
        continue;
      }

      // Found an 1 cell
      const queue = [{ x: i, y: j, island: new Island(i * n + j, 0) }];

      while (queue.length > 0) {
        //
        const { x, y, island } = queue.shift()!;

        if (visited[x][y]) {
          continue;
        }

        visited[x][y] = true;

        if (grid[x][y] === 0) {
          continue;
        }

        const position = x * n + y;
        island.area++;

        islands.set(position, island);

        // Prepare for the next queue
        for (const [dx, dy] of directions) {
          const newX = x + dx;
          const newY = y + dy;

          if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
            continue;
          }

          if (visited[newX][newY]) {
            continue;
          }

          //
          queue.push({ x: newX, y: newY, island });
        }
      }
    }
  }

  return islands;
}

function largestIsland(grid: number[][]): number {

  const islands = cell2island(grid);

  let max = Math.max(...[...islands.values()].map(c => c.area));

  const n = grid.length;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 0) {
        //
        const connected = directions.map(([x, y]) => [x + i, y + j])
          .filter(([x, y]) => x >= 0 && x < n && y >= 0 && y < n && grid[x][y] === 1)
          // .map(([x, y]) => x * n + y)
          .map(([x, y]) => islands.get(x * n + y)!);

        max = Math.max(max, 1 + [...new Set(connected)].reduce(
          (accumulated, value) => accumulated + value.area, 0
        ))
      }
    }
  }

  return max;
};


console.log(largestIsland([
  [1, 1, 0, 1],
  [1, 1, 0, 1],
  [1, 1, 0, 1],
  [1, 1, 0, 1],
]));
