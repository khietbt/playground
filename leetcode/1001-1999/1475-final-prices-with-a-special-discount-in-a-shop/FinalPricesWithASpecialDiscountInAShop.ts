function finalPrices(prices: number[]): number[] {
  const stack: number[] = [];

  prices.forEach(
    (value, i) => {
      while (stack.length > 0 && prices[stack[stack.length - 1]] >= value) {
        prices[stack.pop() ?? 0] -= value;
      }

      stack.push(i);
    });


  return prices;
};

const prices = [8, 4, 6, 2, 3];

console.log(finalPrices(prices));
