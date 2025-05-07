function countSubarrays(numbers: number[], k: number): number {
  if (numbers.length === 0) {
    return 0;
  }

  if (k < 1) {
    return -1;
  }

  const maxElement = Math.max(...numbers);
  const totalElements = numbers.length;

  let totalMaxElements = 0;
  let totalSubarrays = 0;

  let i = 0;
  let j = 0;

  while (i < totalElements) {
    while (j < totalElements && totalMaxElements < k) {
      if (numbers[j] === maxElement) {
        totalMaxElements++;
      }

      // Prepare for the next round
      j++;
    }

    if (totalMaxElements < k) {
      break;
    }

    totalSubarrays += totalElements - j + 1;

    // Prepare for the next round
    if (numbers[i] === maxElement) {
      totalMaxElements--;
    }

    i++;
  }

  return totalSubarrays;
}

// ---------------------------------------------------------------------------
// Main function
// ---------------------------------------------------------------------------
const numbers = [1, 3, 2, 3, 3];
const k = 2;

console.log(countSubarrays(numbers, k));
