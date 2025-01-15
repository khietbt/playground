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

function leafSimilar(root1: TreeNode | null, root2: TreeNode | null): boolean {
  const getLeaves = (root: TreeNode | null) => {
    if (root == null) {
      return [];
    }

    const leaves: TreeNode[] = [];
    const queue: TreeNode[] = [root];

    while (queue.length > 0) {
      const node = queue.shift();

      if (node?.left == null && node?.right == null) {
        leaves.push(node!);
      }

      if (node?.right != null) {
        queue.unshift(node.right);
      }

      if (node?.left != null) {
        queue.unshift(node.left);
      }
    }

    return leaves;
  };

  const lefts = getLeaves(root1);
  const rights = getLeaves(root2);

  if (lefts.length !== rights.length) {
    return false;
  }

  return lefts.length === rights.length
    && lefts.every((element, index) => element.val === rights[index].val);
};
