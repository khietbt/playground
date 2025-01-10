function wordSubsets(words1: string[], words2: string[]): string[] {
  const alphabets = "abcdefghijklmnopqrstuvwxyz".split("");

  const initialized = () => alphabets.reduce((accumulated, value) => {
    accumulated[value] = 0;
    return accumulated;
  }, {});

  const convert = (s: string) => s.split("").reduce(
    (accumulated, currentValue) => {
      accumulated[currentValue] += 1;
      return accumulated;
    }, initialized()
  );

  const maxConverted = (words: string[]) => words2.reduce((accumulated, value) => {
    const converted = convert(value);

    alphabets.forEach(
      c => accumulated[c] = Math.max(accumulated[c], converted[c])
    );

    return accumulated;
  }, initialized());

  const max = maxConverted(words2);

  const isValid = (w: string) => {
    const converted = convert(w);

    for (let i = 0; i < 26; i++) {
      if (max[alphabets[i]] > converted[alphabets[i]]) {
        return false;
      }
    }

    return true;
  }

  return words1.reduce(
    (accumulated, value) => {
      if (isValid(value)) {
        accumulated.push(value);
      }

      return accumulated;
    }, [] as string[]
  )
};

console.log(wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], ["e", "o"]));
console.log(wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], ["l", "e"]));
