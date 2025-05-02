function minEatingSpeed(piles: number[], h: number): number {
  let left = Math.min(...piles);
  let right = Math.max(...piles);

  const canEatAllBananas = (totalBananasPerHour: number) => {
    let sum = 0;

    for (let i = 0; i < piles.length; i++) {
      sum += Math.ceil(piles[i] / totalBananasPerHour);

      if (sum > h) {
        return false;
      }
    }

    return true;
  }

  while (left < right) {
    const mid = left + ((right - left) >> 1);

    if (canEatAllBananas(mid)) {
      right = mid;
      //
    } else {
      left = mid + 1;
    }
    //
  }

  return left;
};

console.log(minEatingSpeed([30, 11, 23, 4, 20], 6));
