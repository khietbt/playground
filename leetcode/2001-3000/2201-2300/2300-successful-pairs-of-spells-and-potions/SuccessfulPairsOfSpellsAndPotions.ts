function successfulPairs(spells: number[], potions: number[], success: number): number[] {
  potions.sort((a, b) => a - b);

  const n = potions.length;

  return spells.map(
    spell => {
      let left = 0;
      let right = n;

      while (left < right) {
        const mid = (left + right) >> 1;

        if (spell * potions[mid] >= success) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return n - left;
    }
  );
};

// console.log(successfulPairs([4, 1, 3], [1, 2, 3, 4, 5], 7));
console.log(successfulPairs([3, 1, 2], [8, 5, 8], 16));

// [5, 10, 15, 20, 25]
// left = 0, right = 5 ==> mid = 3 ==> values[3] = 20 > 7 ==> right = mid - 1 = 2
// left = 0, right = 2 ==> mid = 1 ==> values[1] = 10 > 7 ==> right = mid - 1 = 0
//
//

// [3, 6, 9, 12, 15]
// left = 0, right = 5 ==> mid = 3 ==> values[3] = 12 > 7 ==> right = 2;
// left = 0, right = 2 ==> mid = 1 ==> values[1] = 6 < 7 ==> left = mid;
