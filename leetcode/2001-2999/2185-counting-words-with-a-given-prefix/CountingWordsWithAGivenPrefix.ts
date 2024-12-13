function prefixCount(words: string[], pref: string): number {
  return words.filter((w) => w.indexOf(pref) === 0).length;
}

console.log(prefixCount(["pay", "attention", "practice", "attend"], "at"));
