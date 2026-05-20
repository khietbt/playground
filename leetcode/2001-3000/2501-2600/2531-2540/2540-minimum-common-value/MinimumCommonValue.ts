function getCommon(nums1: number[], nums2: number[]): number {
  const n1 = nums1.length;
  const n2 = nums2.length;
  let i1 = 0;
  let i2 = 0;

  while (i1 < n1 && i2 < n2) {
    if (nums1[i1] === nums2[n2]) {
      return nums1[i1];
    }

    if (nums1[i1] > nums2[i2]) {
      i2++;
      continue;
    }

    i1++;
  }

  return -1;
};
