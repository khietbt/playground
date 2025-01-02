function findDifference(lhs: number[], rhs: number[]): number[][] {
  const [left, right] = [new Set(lhs), new Set(rhs)];

  return [
    [...left].filter(i => !right.delete(i)),
    [...right]
  ];
};

console.log(findDifference([1, 2, 3], [2, 4, 6]))
