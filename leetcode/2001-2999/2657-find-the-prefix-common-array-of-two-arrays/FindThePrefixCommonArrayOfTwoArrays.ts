function findThePrefixCommonArray(lhs: number[], rhs: number[]): number[] {
  const answers = new Array(lhs.length).fill(0);

  const occurrences = new Array(lhs.length + 1).fill(0);

  let accumulatedTotalCommonElements = 0;

  for (let i = 0; i < lhs.length; i++) {
    occurrences[lhs[i]]++;

    if (occurrences[lhs[i]] === 2) {
      accumulatedTotalCommonElements++;
    }

    occurrences[rhs[i]]++;

    if (occurrences[rhs[i]] === 2) {
      accumulatedTotalCommonElements++;
    }

    answers[i] = accumulatedTotalCommonElements;
  }

  return answers;
};


// console.log(findThePrefixCommonArray([1, 2, 3, 4], [4, 3, 2, 1]));
console.log(findThePrefixCommonArray([1, 3, 2, 4], [3, 1, 2, 4]));
