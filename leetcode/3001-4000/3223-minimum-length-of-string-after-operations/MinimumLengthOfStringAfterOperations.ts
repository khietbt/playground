function minimumLength(s: string): number {
  const characters = s.split("").reduce(
    (accumulated, value) => {
      accumulated[value] = (accumulated[value] ?? 0) + 1
      return accumulated;
    }, {}
  )
  const totalCharacters = Object.values(characters) as number[];

  return totalCharacters.reduce(
    (accumulated, value) => {
      return accumulated + (value % 2 === 0 ? 2 : 1)
    }, 0
  )
};

console.log(minimumLength("abaacbcbb"));
