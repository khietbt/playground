function removeOccurrences(s: string, part: string): string {
  let answer = "";

  for (let i = 0; i < s.length; i++) {
    answer += s[i];

    while (answer.length >= part.length && answer.substring(answer.length - part.length) === part) {
      answer = answer.substring(0, answer.length - part.length);
    }
  }

  return answer;
};

console.log(removeOccurrences("aaabcbccc", "abc"));
