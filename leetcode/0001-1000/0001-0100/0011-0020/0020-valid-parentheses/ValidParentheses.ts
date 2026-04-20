function isValid(s: string): boolean {
  const stack: string[] = [];

  for (const c of s) {
    switch (c) {
      case "{":
      case "[":
      case "(":
        stack.push(c);
        continue;
      case "}":
        if (stack.pop() !== "{") {
          return false;
        }

        break;
      case "]":
        if (stack.pop() !== "[") {
          return false;
        }

        break;
      case ")":
        if (stack.pop() !== "(") {
          return false;
        }

        break;
    }
  }

  return stack.length === 0;
}

console.log(isValid("()[]{}"));
console.log(isValid("([)]"));
