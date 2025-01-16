function checkIfExist(numbers: number[]): boolean {
  const cache = {}

  for (const number of numbers) {
    if (cache[number * 2] !== undefined || (number % 2 === 0 && cache[number / 2] !== undefined)) {
      return true;
    }

    cache[number] = true;
  }

  return false;
};

console.log(checkIfExist([10, 2, 5, 3]));
console.log(checkIfExist([3, 1, 7, 11]));
