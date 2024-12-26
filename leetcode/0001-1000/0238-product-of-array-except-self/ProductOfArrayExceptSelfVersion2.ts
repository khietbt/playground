function productExceptSelf(numbers: number[]): number[] {
  const results = new Array(numbers.length).fill(1);

  let left = 1;
  let right = 1;
  const length = numbers.length;

  for (let i = 0; i < length; i++) {
    results[i] *= left;
    results[length - i - 1] *= right;

    left *= numbers[i];
    right *= numbers[length - i - 1];
  }

  return results;
};

console.log(productExceptSelf([1, 2, 3, 4, 5]));
console.log(productExceptSelf([1, 0, 3, 4, 5]));
console.log(productExceptSelf([1, 0, 3, 0, 5]));
