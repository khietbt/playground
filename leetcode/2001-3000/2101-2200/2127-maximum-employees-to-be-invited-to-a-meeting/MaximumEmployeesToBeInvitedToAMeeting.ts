const maxCircleSize = (favourites: number[]): number => {
  let size = 0;
  let max = 1;

  const seens: Set<number> = new Set();

  for (let i = 0; i < favourites.length; i++) {
    const currentCircle: Set<number> = new Set();
    size = 0;
    let node = i;

    while (!currentCircle.has(node) && !seens.has(node)) {
      currentCircle.add(node);
      size++;
      node = favourites[node];
    }

    if (node === i) {
      max = Math.max(max, size);

      currentCircle.forEach(e => seens.add(e));
    }
  }

  return max;
}

const maxChainLength = (favourites: number[]): number => {
  const n = favourites.length;
  const levels: number[] = new Array(n).fill(0);
  const distances: number[] = new Array(n).fill(1);

  for (let i = 0; i < n; i++) {
    levels[favourites[i]]++;
  }

  const queue: number[] = [];

  for (let i = 0; i < n; i++) {
    if (levels[i] === 0) {
      queue.push(i);
    }
  }

  while (queue.length > 0) {
    const node = queue.shift()!;
    const next: number = favourites[node];

    distances[next] = Math.max(distances[node] + 1, distances[next]);
    levels[next]--;

    if (levels[next] === 0) {
      queue.push(next);
    }
  }

  return distances.filter((_, i) => i === favourites[favourites[i]])
    .reduce((accumulated, value) => accumulated + value, 0);
}

function maximumInvitations(favourites: number[]): number {
  return Math.max(maxCircleSize(favourites), maxChainLength(favourites));
};

console.log(maximumInvitations([1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10]));
