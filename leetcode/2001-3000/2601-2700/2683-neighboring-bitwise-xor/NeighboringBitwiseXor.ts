function doesValidArrayExist(derived: number[]): boolean {
  return derived.reduce((accumulated, value) => accumulated ^ value, 0) === 0;
};

console.log(doesValidArrayExist([0, 1, 1]));
