function productExceptSelf(numbers: number[]): number[] {
  const { totalZeros, product, lastZeroIndex } = numbers.reduce(
    (previousAccumulated, currentValue, currentIndex) => {
      const { totalZeros, product, lastZeroIndex } = previousAccumulated;

      if (currentValue === 0) {
        return {
          totalZeros: totalZeros + 1,
          product,
          lastZeroIndex: currentIndex
        };
      }

      return {
        totalZeros,
        product: product * currentValue,
        lastZeroIndex
      };
    },

    { totalZeros: 0, product: 1, lastZeroIndex: -1 }
  );

  if (totalZeros >= 2) {
    return numbers.fill(0);
  }

  if (totalZeros === 1) {
    numbers.fill(0);

    numbers[lastZeroIndex] = product;

    return numbers;
  }

  numbers.forEach(
    (value, index) => {
      numbers[index] = product / value;
    }
  )

  return numbers;
};

console.log(productExceptSelf([1, 2, 3, 4, 5]));
console.log(productExceptSelf([1, 0, 3, 4, 5]));
console.log(productExceptSelf([1, 0, 3, 0, 5]));
