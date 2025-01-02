function pivotIndex(numbers: number[]): number {
  if (numbers.length < 2) {
    return 0;
  }

  const accumulated = new Array(numbers.length + 1).fill(0);

  numbers.forEach((v, i) => {
    accumulated[i + 1] = accumulated[i] + numbers[i]
  });

  for (let i = 0; i < numbers.length; i++) {
    const left = accumulated[i] - accumulated[0];
    const right = accumulated[numbers.length] - accumulated[i + 1];

    if (left === right) {
      return i;
    }
  }

  return -1;
};

console.log(pivotIndex([1, 7, 3, 6, 5, 6]))
console.log(pivotIndex([2, 1, -1]));

