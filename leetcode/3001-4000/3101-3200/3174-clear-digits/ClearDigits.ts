function clearDigits(s: string): string {
  const buffer: string[] = [];

  for (let i = 0; i < s.length; i++) {
    if ("0" <= s[i] && "9" >= s[i]) {
      buffer.pop();

      continue;
    }

    buffer.push(s[i]);
  }

  return buffer.join("");
};

console.log(clearDigits("abc34"));
