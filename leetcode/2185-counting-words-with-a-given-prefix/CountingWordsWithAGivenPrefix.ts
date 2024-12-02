function prefixCount(words: string[], pref: string): number {
    return words.filter((w) => w.indexOf(pref) === 0).length;
}

const words = ["pay","attention","practice","attend"];
const pref = "at";

console.log(prefixCount(words, pref));