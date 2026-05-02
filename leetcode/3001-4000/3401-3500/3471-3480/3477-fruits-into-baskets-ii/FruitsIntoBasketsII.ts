function numOfUnplacedFruits(fruits: number[], baskets: number[]): number {
  let unplaced = 0;

  for (const fruit of fruits) {
    let used = -1;

    for (let i = 0; i < baskets.length; i++) {
      const basket = baskets[i];

      if (basket >= fruit) {
        used = i;
        baskets.splice(i, 1);
        break;
      }
    }

    if (used === -1) {
      unplaced++;
    }
  }

  return unplaced;
}

console.log(numOfUnplacedFruits([4, 2, 5], [3, 5, 4]));
console.log(numOfUnplacedFruits([3, 6, 1], [6, 4, 7]));
