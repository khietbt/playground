function eventualSafeNodes(graph: number[][]): number[] {
  const n = graph.length;
  const eventuals = new Array(n).fill(false);
  const visited = new Array(n).fill(false);


  const isEventual = (i: number): boolean => {
    if (visited[i]) {
      return eventuals[i];
    }

    visited[i] = true;

    for (const neighbour of graph[i]) {
      if (!isEventual(neighbour)) {
        return false;
      }
    }

    eventuals[i] = true;

    return eventuals[i];
  }

  for (let i = 0; i < n; i++) {
    isEventual(i);
  }

  return eventuals.map((v, i) => v ? i : null).filter(v => v !== null);
};

console.log(eventualSafeNodes([[1, 2], [2, 3], [5], [0], [5], [], []]));
