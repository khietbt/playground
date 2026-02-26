function numSteps(s: string): number {
  let steps = 0;
  let c = 0;

  for (let i = s.length - 1; i > 0; i--) {
    let v = s.charCodeAt(i) - 48;

    steps += 1 + (v ^ c);
    c = v | c;
  }

  return steps + c;
}

console.log(numSteps("1101"));
