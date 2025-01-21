class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
  }
}

function maxLevelSum(root: TreeNode | null): number {
  if (root == null) {
    return 0;
  }

  const sums: number[] = [];

  const bfs = (node: TreeNode, depth: number): void => {
    if (depth === sums.length) {
      sums.push(node.val);
    } else {
      sums[depth] += node.val;
    }

    if (node.left) {
      bfs(node.left, depth + 1);
    }

    if (node.right) {
      bfs(node.right, depth + 1)
    }
  }

  bfs(root, 0);

  let level = 0;
  let max = sums[0];

  for (let i = 1; i < sums.length; i++) {
    if (max < sums[i]) {
      max = sums[i];
      level = i;
    }
  }

  return level + 1;
};

const root = new TreeNode(
  1,
  new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
  new TreeNode(0));

console.log(maxLevelSum(root));
