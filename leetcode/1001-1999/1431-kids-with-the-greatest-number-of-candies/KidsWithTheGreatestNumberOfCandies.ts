function kidsWithCandies(candies: number[], extraCandies: number): boolean[] {
  const max = Math.max(...candies);
  const rhs = max - extraCandies;

  return candies.map(c => c >= rhs);
};
