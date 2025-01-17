function gcdOfStrings(s1: string, s2: string): string {
  if (s1 + s2 != s2 + s1) {
    return "";
  }

  const gcd = (a: number, b: number): number => {
    while (b !== 0) {
      [a, b] = [b, a % b];
    }

    return a;
  }

  return s1.substring(0, gcd(s1.length, s2.length));
};

console.log(gcdOfStrings("ABCABC", "ABC"));
