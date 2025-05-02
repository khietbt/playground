function eraseOverlapIntervals(intervals: number[][]): number {
  if (intervals.length === 0) {
    return 0;
  }

  let removals = 0;

  intervals.sort((a, b) => a[1] - b[1]);

  let previous = intervals[0][1];

  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] < previous) {
      removals++;
    } else {
      previous = intervals[i][1];
    }
  }

  return removals;
};

// console.log(eraseOverlapIntervals([[1, 2], [2, 3], [3, 4], [1, 3]]));
console.log(eraseOverlapIntervals([[1, 2], [1, 2], [1, 2]]));

