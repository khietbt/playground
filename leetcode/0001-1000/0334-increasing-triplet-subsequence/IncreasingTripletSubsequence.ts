function increasingTriplet(numbers: number[]): boolean {
  let smallest = Number.MAX_VALUE;
  let middle = Number.MAX_VALUE;

  for (const number of numbers) {
    if (number > middle) {
      return true;
    } else if (number < smallest) {
      smallest = number;
    } else {
      middle = number;
    }
  }

  return false;
};

console.log([2, 1, 5, 0, 4, 6]);
