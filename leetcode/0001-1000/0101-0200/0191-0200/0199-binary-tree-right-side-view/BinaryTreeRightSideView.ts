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

function rightSideView(root: TreeNode | null): number[] {
  if (root == null) {
    return [];
  }

  const answer = {};

  const queue: { node: TreeNode, depth: number }[] = [{ node: root, depth: 0 }];

  while (queue.length > 0) {
    const { node, depth } = queue.shift()!;

    answer[depth] = node.val;

    if (node.left) {
      queue.push({ node: node.left, depth: depth + 1 });
    }

    if (node.right) {
      queue.push({ node: node.right, depth: depth + 1 });
    }
  }

  return Object.values(answer);
};

const root = new TreeNode(
  1,
  new TreeNode(
    2,
    new TreeNode(
      4,
      new TreeNode(5))
  ),
  new TreeNode(3)
);

console.log(rightSideView(root));
