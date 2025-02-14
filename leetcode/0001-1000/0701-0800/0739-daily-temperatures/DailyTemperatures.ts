function dailyTemperatures(temperatures: number[]): number[] {
  const stack: number[] = [];

  return temperatures.reduceRight(
    (accumulated, value, i) => {
      while (stack.length > 0 && temperatures[stack[stack.length - 1]] <= value) {
        stack.pop();
      }

      accumulated[i] = (stack.at(-1) ?? i) - i;

      stack.push(i);

      return accumulated;
    }, new Array(temperatures.length).fill(0) as number[]
  );
}

console.log(dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]));

