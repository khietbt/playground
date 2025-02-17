function numTilePossibilities(s: string): number {
  const tiles: { [id: string]: number } = {};

  for (let i = 0; i < s.length; i++) {
    tiles[s[i]] = (tiles[s[i]] ?? 0) + 1;
  }

  const dfs = () => {
    let cases = 0;

    for (const k of Object.keys(tiles)) {
      if (tiles[k] > 0) {
        tiles[k]--;

        cases += 1 + dfs();

        tiles[k]++;
      }
    }

    return cases;
  }

  return dfs();
};

console.log(numTilePossibilities("A"));
