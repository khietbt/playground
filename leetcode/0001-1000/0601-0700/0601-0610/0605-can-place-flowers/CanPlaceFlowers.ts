function canPlaceFlowers(flowerbed: number[], n: number): boolean {
  const length = flowerbed.length;

  const extra = flowerbed.reduce(
    (extra, currentValue, currentIndex, bed) => {
      const left = currentIndex === 0 ? 0 : bed[currentIndex - 1];
      const right = currentIndex === length - 1 ? 0 : bed[currentIndex + 1];

      if (left + right + currentValue === 0) {
        bed[currentIndex] = 1;

        return extra + 1;
      }

      return extra;
    }, 0);

  return extra >= n;
};

console.log(canPlaceFlowers([1, 0, 0, 0, 1, 0, 0], 2));
