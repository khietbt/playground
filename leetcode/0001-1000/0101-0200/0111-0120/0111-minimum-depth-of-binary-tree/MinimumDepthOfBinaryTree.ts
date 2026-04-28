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

function minDepth(root: TreeNode | null): number {
  if (root == null) {
    return 0;
  }

  let queue: TreeNode[] = [root];
  let height = 0;

  while (queue.length > 0) {
    let size = queue.length;
    height++;

    for (let i = 0; i < size; i++) {
      let node = queue.shift()!;

      if (node.left == null && node.right == null) {
        return height;
      }

      if (node.left != null) {
        queue.push(node.left);
      }

      if (node.right != null) {
        queue.push(node.right);
      }
    }
  }

  return 0;
}
