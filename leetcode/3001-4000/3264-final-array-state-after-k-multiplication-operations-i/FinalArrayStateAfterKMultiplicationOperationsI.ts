function getFinalState(numbers: number[], k: number, multiplier: number): number[] {
  while (k-- > 0) {
    const { index, value } = numbers.reduce((min, currentValue, currentIndex) => {
      const { value } = min;

      if (value > currentValue) {
        return {
          index: currentIndex,
          value: currentValue
        };
      }

      return min;
    }, { index: 0, value: numbers[0] });

    numbers[index] = value * multiplier;
  }
  return numbers;
};

const numbers = [1, 2];
const k = 3;
const multiplier = 4;

console.log(getFinalState(numbers, k, multiplier))
