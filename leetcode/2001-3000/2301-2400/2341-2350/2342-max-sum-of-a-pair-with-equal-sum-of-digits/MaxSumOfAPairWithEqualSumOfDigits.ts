function maximumSum(nums: number[]): number {
  let max = -1;
  const digitSums = {};

  const calculateDigitSum = (n: number) => {
    let sum = 0;

    while (n > 0) {
      sum += n % 10;
      n = Math.floor(n / 10);
    }

    return sum;
  }

  for (let i = 0; i < nums.length; i++) {
    const digitSum = calculateDigitSum(nums[i]);
    const numbers = digitSums[digitSum] ?? [];

    if (numbers.length === 2) {
      if (numbers[0] > numbers[1]) {
        numbers[1] = Math.max(numbers[1], nums[i]);
      } else {
        numbers[0] = Math.max(numbers[0], nums[i]);
      }
    } else {
      numbers.push(nums[i]);
    }

    if (numbers.length === 2) {
      max = Math.max(max, numbers[1] + numbers[0]);
    }

    digitSums[digitSum] = numbers;
  }

  return max;
};

// console.log(maximumSum([18, 43, 36, 13, 7]));
console.log(maximumSum([279, 169, 463, 252, 94, 455, 423, 315, 288, 64, 494, 337, 409, 283, 283, 477, 248, 8, 89, 166, 188, 186, 128]));
