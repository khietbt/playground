function maxProfit(prices: number[], strategy: number[], k: number): number {
  let original = 0;
  let change = 0;
  let accumulated = 0;

  for (let i = 0; i < prices.length; i++) {
    const price = prices[i];
    const action = strategy[i];

    original += price * action;
    accumulated += price;

    if (i < k / 2) {
      continue;
    }

    const right = accumulated - prices[i - k / 2];

    if (i < k) {
      continue;
    }

    const left = original - prices[i - k] * strategy[i - k];

    change = Math.max(change, right - left);
  }

  return original + change;
}

console.log(maxProfit([4, 2, 8], [-1, 0, 1], 2));
console.log(maxProfit([5, 4, 3], [1, 1, 0], 2));
