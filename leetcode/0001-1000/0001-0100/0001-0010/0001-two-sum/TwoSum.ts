function twoSum(numbers: number[], target: number): number[] {
  const cached: Record<number, number> = {};

  for (let i = 0; i < numbers.length; i++) {
    const lhs = numbers[i];
    const rhs = target - lhs;

    if (cached[rhs] !== undefined) {
      return [cached[rhs], i];
    }

    cached[lhs] = i;
  }

  return [];
};

console.log(twoSum([2, 7, 11, 15], 9)); // Output: [0, 1]
