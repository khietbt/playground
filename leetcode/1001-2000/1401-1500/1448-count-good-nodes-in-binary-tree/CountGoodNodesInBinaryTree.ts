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

function goodNodes(root: TreeNode | null): number {
  if (root == null) {
    return 0;
  }

  const queue: { node: TreeNode, max: number }[] = [{ node: root, max: Number.NEGATIVE_INFINITY }];
  let totalGoodNodes = 0;

  while (queue.length > 0) {
    let { node, max } = queue.shift()!;

    if (node.val >= max) {
      totalGoodNodes++;
    }

    max = Math.max(max, node.val);

    if (node.right != null) {
      queue.unshift({ node: node.right, max });
    }

    if (node.left != null) {
      queue.unshift({ node: node.left, max })
    }
  }

  return totalGoodNodes;
};

console.log(goodNodes(new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null)));
