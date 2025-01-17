/**
 Do not return anything, modify nums in-place instead.
 */
function moveZeroes(numbers: number[]): void {
  let i = 0;

  for (const number of numbers) {
    if (number !== 0) {
      numbers[i++] = number;
    }
  }

  while (i < numbers.length) {
    numbers[i++] = 0;
  }
};

const numbers = [0, 1, 0, 3, 12];

moveZeroes(numbers);

console.log(numbers);
