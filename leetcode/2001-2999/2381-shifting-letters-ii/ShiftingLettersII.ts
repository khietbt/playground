function shiftingLetters(s: string, shifts: number[][]): string {
  const n = s.length;
  let changes = new Array(n + 1).fill(0);

  for (const [left, right, direction] of shifts) {
    const v = direction === 1 ? 1 : -1;

    changes[left] += v;
    changes[right + 1] -= v;
  }

  for (let i = 1; i <= n; i++) {
    changes[i] += changes[i - 1];
  }

  let output = "";

  for (let i = 0; i < n; i++) {
    let c = ((s.charCodeAt(i) - 97 + changes[i]) % 26 + 26) % 26 + 97
    // let c = (((s.charCodeAt(i) - 97) + changes[i]) % 26 + 26) % 26 + 97;

    output = output + String.fromCharCode(c);
  }

  return output;
};

// console.log(shiftingLetters("abc", [[0, 1, 0], [1, 2, 1], [0, 2, 1]]));
console.log(shiftingLetters("dztz", [[0, 0, 0], [1, 1, 1]]));
