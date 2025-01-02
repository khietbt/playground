function largestAltitude(gain: number[]): number {
  const { max } = gain.reduce(
    (accumulated, currentValue) => {
      let { max, current } = accumulated;

      current = current + currentValue;
      max = Math.max(max, current);

      return { max, current };
    },
    {
      max: 0,
      current: 0
    }
  );

  return max;
};

console.log(largestAltitude([-5, 1, 5, 0, -7]));
