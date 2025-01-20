class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function pathSum(root: TreeNode | null, target: number): number {
  const prefixes: Map<number, number> = new Map();

  const dfs = (node: TreeNode | null, current: number): number => {
    if (node == null) {
      return 0;
    }

    current += node.val;

    let totalPaths = prefixes.get(current - target) || 0;

    const currentPrefix = prefixes.get(current) || 0;

    prefixes.set(current, currentPrefix + 1)

    totalPaths += dfs(node.left, current);
    totalPaths += dfs(node.right, current);

    prefixes.set(current, currentPrefix - 1)

    return totalPaths;
  };

  prefixes.set(0, 1);

  return dfs(root, 0);
};

let root = new TreeNode(
  2,
  new TreeNode(
    1,
    new TreeNode(
      0,
      new TreeNode(
        3,
        new TreeNode(4),
        null),
      null),
    null),
  null);

root = new TreeNode(3, root, null);

const target = 3;

console.log(pathSum(root, target))
