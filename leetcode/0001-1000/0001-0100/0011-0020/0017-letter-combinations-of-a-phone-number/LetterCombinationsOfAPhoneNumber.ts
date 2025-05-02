function letterCombinations(digits: string): string[] {
  if (digits.length === 0) {
    return [];
  }

  const dictionary = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz"
  };

  let answers: string[] = [""];

  for (let i = 0; i < digits.length; i++) {
    const digit = digits[i];
    const letters = dictionary[digit];

    const temp: string[] = [];

    for (let j = 0; j < letters.length; j++) {
      const letter = letters[j];

      answers.forEach(
        e => temp.push(e + letter)
      );
    }

    answers = temp;
  }

  return answers;
};

console.log(letterCombinations("23"));
