function minimizeXor(num1: number, num2: number): number {
  const getTotalBits = (number: number) => {
    number = number - ((number >>> 1) & 0x55555555);
    number = (number & 0x33333333) + ((number >>> 2) & 0x33333333);
    number = (number + (number >>> 4)) & 0x0f0f0f0f;
    number = number + (number >>> 8);
    number = number + (number >>> 16);

    return number & 0x3f;
  }

  let difference = getTotalBits(num1) - getTotalBits(num2);

  while (difference > 0) {
    num1 &= num1 - 1;
    difference--;
  }

  while (difference < 0) {
    num1 |= num1 + 1;
    difference++;
  }

  return num1;
};

console.log(minimizeXor(65, 84))
