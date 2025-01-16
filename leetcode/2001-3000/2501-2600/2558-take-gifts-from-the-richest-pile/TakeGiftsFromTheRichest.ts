// Brute force
function pickGifts(gifts: number[], k: number): number {
  while (k-- > 0) {
    const { index, value } = gifts.reduce((previousAccumulated, currentElement, currentIndex) => {
      const { value } = previousAccumulated;

      if (currentElement > value) {
        return {
          index: currentIndex,
          value: currentElement
        };
      }

      return previousAccumulated;

    }, { index: 0, value: gifts[0] });

    gifts[index] = Math.floor(Math.sqrt(value));
  }

  return gifts.reduce((previousAccumulatedValue, currentElement) => previousAccumulatedValue + currentElement, 0);
};

const gifts = [25, 64, 9, 4, 100];
const k = 4;

console.log(pickGifts(gifts, k));
