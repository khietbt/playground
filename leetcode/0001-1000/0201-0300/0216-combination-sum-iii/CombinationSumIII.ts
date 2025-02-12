function combinationSum3(k: number, n: number): number[][] {
  const paths: number[][] = [];

  const dfs = (remainingNumbers: number, remainingSum: number, start: number, path: number[]) => {
    if (remainingNumbers < 0 || remainingSum < 0) {
      return;
    }

    if (remainingNumbers === 0 && remainingSum === 0) {
      paths.push([...path]);
    }

    for (let s = start; s <= 9; s++) {
      path.push(s);
      dfs(remainingNumbers - 1, remainingSum - s, s + 1, path);
      path.pop();
    }
  };

  dfs(k, n, 1, []);

  return paths;
};

console.log(combinationSum3(3, 9));
