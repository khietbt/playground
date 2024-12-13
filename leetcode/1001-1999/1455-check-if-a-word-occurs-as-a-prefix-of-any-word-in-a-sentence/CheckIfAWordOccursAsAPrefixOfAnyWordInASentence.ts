function isPrefixOfWord(sentence: string, searchWord: string): number {
  let i = 0;
  let w = 1;

  while (i < sentence.length) {
    let j = i;
    let m = i + searchWord.length;

    if (m > sentence.length) {
      break;
    }

    while (j < m) {
      if (sentence.charAt(j) !== searchWord.charAt(j - i)) {
        break;
      }

      j++;
    }

    if (j === m) {
      return w;
    }

    while (j < sentence.length && sentence.charAt(j) !== " ") {
      j++;
    }

    i = j + 1;
    w++;
  }

  return -1;
};

console.log(isPrefixOfWord("this problem is an easy problem", "pro"));
console.log(isPrefixOfWord("i love eating burger", "burg"));
