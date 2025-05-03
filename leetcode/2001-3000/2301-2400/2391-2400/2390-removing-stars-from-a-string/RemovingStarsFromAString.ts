function removeStars(s: string): string {
  let result: string[] = [];

  for (const c of s.split("")) {
    if (c === '*') {
      result.pop();
    } else {
      result.push(c);
    }
  }

  return result.join("");
};

console.log(removeStars("leet**cod*e"));
