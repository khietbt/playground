function compress(chars: string[]): number {
  const length = chars.length;

  let i = 0;
  let w = 0;

  while (i < length) {
    let j = i + 1;

    while (j < length && chars[j] === chars[i]) {
      j++;
    }

    chars[w++] = chars[i];

    if (j - i > 1) {
      `${j - i}`.split("").forEach(
        c => chars[w++] = c
      );
    }

    i = j;
  }

  return w;
};

console.log(compress(["a", "a", "b", "b", "c", "c", "c"]));
