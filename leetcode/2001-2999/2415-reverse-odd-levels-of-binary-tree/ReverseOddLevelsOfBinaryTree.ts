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

function reverseOddLevels(root: TreeNode | null): TreeNode | null {
  if (!root) {
    return null;
  }

  const nodes: TreeNode[] = [];

  nodes.push(root);

  let level = 0;
  let totalElements = 1 << level;
  let mid = totalElements / 2;

  while (nodes.length > 0) {
    if (level % 2 == 1) {
      for (let i = mid; i < totalElements; i++) {
        const t = nodes[i].val;
        nodes[i].val = nodes[mid - (i - mid) - 1].val;
        nodes[totalElements - i - 1].val = t;
      }
    }

    for (let i = 0; i < totalElements; i++) {
      let node = nodes.shift();

      if (node && node.left && node?.right) {
        nodes.push(node.left);
        nodes.push(node?.right);
      }
    }

    level++;
    totalElements = 1 << level;
    mid = totalElements >> 1;
  }

  return root;
};
