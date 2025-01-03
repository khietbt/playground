function closeStrings(lhs: string, rhs: string): boolean {
  if (lhs.length !== rhs.length) {
    return false;
  }

  if (lhs === rhs) {
    return true;
  }

  const convert = (s: string) => s.split("").reduce(
    (accumulated, currentValue) => {
      accumulated[currentValue] = (accumulated[currentValue] ?? 0) + 1;

      return accumulated;
    }, {}
  )

  const left = convert(lhs);
  const right = convert(rhs);

  console.log(Object.keys(left).sort().toString());
  console.log(Object.keys(right).sort().toString());

  return Object.keys(left).sort().toString() === Object.keys(right).sort().toString()
    && Object.values(left).sort().toString() === Object.values(right).sort().toString();
};

console.log(closeStrings("abc", "bca"));
