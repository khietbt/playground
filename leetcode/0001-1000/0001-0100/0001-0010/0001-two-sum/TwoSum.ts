function twoSum(numbers: number[], target: number): number[] {
    const cached: Record<number, number> = {};

    for (let i = 0; i < numbers.length; i++) {
        const complement = target - numbers[i];

        // Check if the complement exists in the cache
        // If it does, return the indices of the two numbers
        // that add up to the target
        if (cached[complement] !== undefined) {
            return [cached[complement], i];
        }

        // Store the index of the current number in the cache
        // to check for its complement in future iterations
        cached[numbers[i]] = i;
    }

    // If no solution is found, return an empty array
    return [];
};

console.log(twoSum([2, 7, 11, 15], 9)); // Output: [0, 1]