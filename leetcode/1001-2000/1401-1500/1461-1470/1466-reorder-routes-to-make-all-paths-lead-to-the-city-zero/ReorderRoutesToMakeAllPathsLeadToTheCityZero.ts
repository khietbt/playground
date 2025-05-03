function minReorder(n: number, connections: number[][]): number {
  const visited = new Array(n).fill(false);
  const graph = new Array(n).fill(null).map(
    (_) => ({ froms: [] as number[], tos: [] as number[] })
  )

  for (const [from, to] of connections) {
    graph[to].froms.push(from);
    graph[from].tos.push(to);
  }

  let totalReorders = 0;

  const visit = (i: number) => {
    if (visited[i]) {
      return;
    }

    visited[i] = true;

    const { froms, tos } = graph[i];

    for (const from of froms) {
      if (!visited[from]) {
        visit(from);
      }
    }

    for (const to of tos) {
      if (!visited[to]) {
        totalReorders++;
        visit(to);
      }
    }
  };

  visit(0);


  return totalReorders;
}
// function minReorder(n: number, connections: number[][]): number {
//   const visited = new Set([0]);
//
//   let totalReorders = 0;
//
//   while (connections.length > 0) {
//     const [from, to] = connections.shift()!;
//
//     if (visited.has(to)) {
//       visited.add(from);
//       continue;
//     }
//
//     if (visited.has(from)) {
//       visited.add(to);
//       totalReorders++;
//       continue;
//     }
//
//     connections.push([from, to]);
//   }
//
//   return totalReorders;
// };

console.log(minReorder(6, [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]));
console.log(minReorder(5, [[1, 0], [1, 2], [3, 2], [3, 4]]));

