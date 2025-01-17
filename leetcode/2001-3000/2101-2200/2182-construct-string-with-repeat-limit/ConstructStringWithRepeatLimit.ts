function repeatLimitedString(s: string, repeatLimit: number): string {
  const totalCharacters = s.split('').reduce(
    (totalCharacters, currentCharacter) => {
      totalCharacters[currentCharacter] = (totalCharacters[currentCharacter] ?? 0) + 1;

      return totalCharacters
    }, {}
  )

  const characters = Object.keys(totalCharacters).sort().reverse();

  return characters.reduce(
    (previous, currentCharacter, currentCharacterIndex) => {
      let current = previous;
      let nextCharacterIndex = currentCharacterIndex + 1;
      // let nextCharacter = characters[nextCharacterIndex];

      while (totalCharacters[currentCharacter] > 0) {
        const k = Math.min(repeatLimit, totalCharacters[currentCharacter]);

        for (let i = 0; i < k; i++) {
          current += currentCharacter;
        }

        totalCharacters[currentCharacter] -= k;

        if (totalCharacters[currentCharacter] < 1) {
          break;
        }

        while (nextCharacterIndex < characters.length && totalCharacters[characters[nextCharacterIndex]] < 1) {
          nextCharacterIndex++;
        }

        if (nextCharacterIndex >= characters.length) {
          break;
        }

        const nextCharacter = characters[nextCharacterIndex];
        current += characters[nextCharacterIndex];
        totalCharacters[nextCharacter]--;

        // Prepare for the next round
      }

      return current;
    }, ""
  );

  // for (let i = 0; i < s.length; i++) {
  //   letters[s.charAt(i)] = (letters[s.charAt(i)] ?? 0) + 1;
  // }
  //
  // return Object.keys(letters).sort().reverse().reduce(
  //   (previousValue, currentCharacter, currentIndex) => {
  //     if (letters[currentCharacter] < 1) {
  //       return previousValue;
  //     }
  //
  //     let currentValue = previousValue;
  //
  //     while (letters[currentCharacter] > 0) {
  //       const k = Math.min(repeatLimit, letters[currentCharacter]);
  //
  //     }
  //
  //
  //     return "";
  //   }, "")
};

const s = "cczazcc";
const repeatLimit = 3;

console.log(repeatLimitedString(s, repeatLimit))
