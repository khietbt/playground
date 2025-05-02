function calcEquation(equations: string[][], values: number[], queries: string[][]): number[] {
  const data = equations.reduce(
    (accumulated, [left, right], i) => {
      if (accumulated.get(left) === undefined) {
        accumulated.set(left, new Map<string, number>());
      }

      if (accumulated.get(right) === undefined) {
        accumulated.set(right, new Map<string, number>());
      }

      accumulated.get(left)!.set(right, values[i]);
      accumulated.get(right)!.set(left, 1 / values[i]);

      return accumulated;
    }, new Map<string, Map<string, number>>()
  );

  const dfs = (left: string, right: string, visited: Set<string>) => {
    if (data.get(left) === undefined || data.get(right) === undefined) {
      return -1;
    }

    if (left === right) {
      return 1;
    }

    visited.add(left);

    for (const bridge of data.get(left)!.keys()) {
      if (visited.has(bridge)) {
        continue;
      }

      const w = dfs(bridge, right, visited);

      if (w > 0) {
        return w * data.get(left)!.get(bridge)!;
      }
    }

    return -1;
  }

  const answers: number[] = queries.map(([left, right]) => dfs(left, right, new Set<string>()));

  return answers;
};

console.log(calcEquation([["a", "b"], ["b", "c"]], [2.0, 3.0], [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]));
