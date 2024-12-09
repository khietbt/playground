function isPrefixString(s: string, words: string[]): boolean {
    let j = 0;

    for (let i = 0; i < words.length && j < s.length; i++) {
        const left = words[i];
        const right = s.substring(j, j + left.length);

        if (left != right) {
            return false;
        }

        j = j + left.length;
    }

    return j == s.length;
}

const s = "iloveleetcode";
const words = ["i", "love", "leetcode", "apples"];

console.log(isPrefixString(s, words));
