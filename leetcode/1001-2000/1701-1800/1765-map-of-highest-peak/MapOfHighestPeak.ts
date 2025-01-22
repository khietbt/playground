function highestPeak(waters: number[][]): number[][] {
  const m = waters.length;
  const n = waters[0].length;

  const peaks: number[][] = new Array(m)
    .fill([])
    .map(() => new Array(n).fill(-1));

  let queue: number[][] = [];

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (waters[i][j] === 1) {
        peaks[i][j] = 0;

        queue.push([i, j]);
      }
    }
  }

  const directions = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1]
  ];

  while (queue.length > 0) {
    const newQueue: number[][] = [];

    for (const [x, y] of queue) {
      for (const [dx, dy] of directions) {
        const newX = x + dx;
        const newY = y + dy;

        if (newX >= 0 && newX < m && newY >= 0 && newY < n && peaks[newX][newY] === -1) {
          peaks[newX][newY] = peaks[x][y] + 1;

          newQueue.push([newX, newY]);
        }
      }
    }

    queue = newQueue;
    // const [x, y] = queue.shift()!;
    //
    // const newNodes = directions.map(direction => [x + direction[0], y + direction[1]])
    //   .filter(([newX, newY]) => newX >= 0 && newX < m && newY >= 0 && newY < n && peaks[newX][newY] === -1);
    //
    // newNodes.forEach((element) => {
    //   peaks[element[0]][element[1]] = peaks[x][y] + 1;
    //   queue.push(element)
    // });
  }

  return peaks;
};

console.log(highestPeak([[0, 0, 1], [1, 0, 0], [0, 0, 0]]))
