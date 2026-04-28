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

function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
  if (root == null) {
    return false;
  }

  let queue: [TreeNode, number][] = [[root, 0]];

  while (queue.length > 0) {
    const size = queue.length;

    for (let i = 0; i < size; i++) {
      const [node, currentSum] = queue.shift()!;

      const sum = node.val + currentSum;

      if (node.left == null && node.right == null) {
        if (sum === targetSum) {
          return true;
        }

        continue;
      }

      if (node.left != null) {
        queue.push([node.left, sum]);
      }

      if (node.right != null) {
        queue.push([node.right, sum]);
      }
    }
  }

  return false;
}
