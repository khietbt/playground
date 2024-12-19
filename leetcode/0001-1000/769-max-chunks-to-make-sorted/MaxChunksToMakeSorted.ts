function maxChunksToSorted(integers: number[]): number {
  const { totalChunks } = integers.reduce(
    (previous, currentElement, currentIndex) => {
      let { totalChunks, max } = previous;

      max = Math.max(max, currentElement);

      if (currentIndex === max) {
        totalChunks++;
      }

      return {
        totalChunks,
        max
      };
    }
    , { totalChunks: 0, max: 0 }
  );

  return totalChunks
};

console.log(maxChunksToSorted([1, 0, 2, 3, 4]));
