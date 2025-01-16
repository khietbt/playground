function minOperations(boxes: string): number[] {
  const n = boxes.length;
  const balls = boxes.split("").map(c => c.charCodeAt(0) - '0'.charCodeAt(0));

  let operations: number[] = new Array(boxes.length).fill(0);

  for (let i = 1, accumulated = 0; i < n; i++) {
    accumulated += balls[i - 1];

    operations[i] = operations[i - 1] + accumulated;
  }

  for (let i = n - 2, accumulated = 0, sum = 0; i >= 0; i--) {
    accumulated += balls[i + 1];

    sum += accumulated;

    operations[i] = operations[i] + sum;
  }

  return operations;
};

console.log(minOperations("001011"));
