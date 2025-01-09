function asteroidCollision(asteroids: number[]): number[] {
  return asteroids.reduce(
    (accumulated: number[], currentValue: number) => {
      if (currentValue > 0) {
        accumulated.push(currentValue);
      } else {
        while (accumulated.length > 0 && accumulated[accumulated.length - 1] > 0 && accumulated[accumulated.length - 1] < -currentValue) {
          accumulated.pop();
        }

        if (accumulated.length > 0 && accumulated[accumulated.length - 1] === -currentValue) {
          accumulated.pop();
        } else if (accumulated.length === 0 || accumulated[accumulated.length - 1] < 0) {
          accumulated.push(currentValue);
        }
      }

      return accumulated;
    }, [] as number[]
  )
};

// console.log(asteroidCollision([5, 10, -5]));
// console.log(asteroidCollision([5, 2, -5]));
console.log(asteroidCollision([-2, -1, 1, 2]));
