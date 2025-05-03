function firstCompleteIndex(arr: number[], mat: number[][]): number {
  const m = mat.length;
  const n = mat[0].length;

  const rows = new Array(m).fill(n);
  const columns = new Array(n).fill(m);

  const values = new Array(m * n).fill(0);

  for (let i = 0; i < mat.length; i++) {
    for (let j = 0; j < mat[0].length; j++) {
      const index = i * n + j;

      values[index] = mat[i][j];
    }
  }

  const indices = new Array(values.length).fill(0);

  for (let i = 0; i < values.length; i++) {
    indices[values[i] - 1] = i;
  }

  for (let i = 0; i < arr.length; i++) {
    const a = arr[i];
    const v = indices[a - 1];

    // The division returns a float, so we need a floor here.
    const r = Math.floor(v / n);
    const c = v % n;

    rows[r]--;
    columns[c]--;

    if (rows[r] === 0 || columns[c] === 0) {
      return i;
    }
  }

  return 0;
};

// console.log(firstCompleteIndex([2, 8, 7, 4, 1, 3, 5, 6, 9], [[3, 2, 5], [1, 4, 6], [8, 7, 9]]));
console.log(firstCompleteIndex([6, 2, 3, 1, 4, 5], [[5, 1], [2, 4], [6, 3]]));
