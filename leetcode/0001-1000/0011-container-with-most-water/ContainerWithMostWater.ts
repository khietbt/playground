function maxArea(heights: number[]): number {
  let left = 0;
  let right = heights.length - 1;
  let area = Number.MIN_VALUE;

  while (left < right) {
    if (heights[left] < heights[right]) {
      area = Math.max(area, (right - left) * heights[left]);
      left++;
    } else {
      area = Math.max(area, (right - left) * heights[right]);
      right--;
    }
  }

  return area;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
