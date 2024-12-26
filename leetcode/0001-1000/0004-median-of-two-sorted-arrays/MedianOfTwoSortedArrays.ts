function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  let current = 0;
  let previous = 0;

  const n = (nums1.length + nums2.length + 1) / 2;
  let i = 0;
  let j = 0;

  for (let index = 0; index < n; index++) {
    previous = current;

    if (i >= nums1.length) {
      current = nums2[j++];
    } else if (j >= nums2.length) {
      current = nums1[i++];
    } else {
      current = nums1[i] >= nums2[j] ? nums2[j++] : nums1[i++];
    }
  }

  if ((nums1.length + nums2.length) % 2 === 1) {
    previous = current;
  }

  return (current + previous) / 2;
};

// 0, 1, 1, 2, 2, 3, 3, 4
console.log(findMedianSortedArrays([0, 1, 2, 3], [1, 2, 3, 4]))
// -1, 0, 1, 1, 2, 2, 3, 3, 4
console.log(findMedianSortedArrays([-1, 0, 1, 2, 3], [1, 2, 3, 4]))
// -2, -1, 0, 1, 1, 2, 2, 3, 3, 4
console.log(findMedianSortedArrays([-2, -1, 0, 1, 2, 3], [1, 2, 3, 4]))

