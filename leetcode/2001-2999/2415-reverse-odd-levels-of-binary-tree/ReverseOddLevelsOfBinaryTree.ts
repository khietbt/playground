class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
  }

  static from(values: number[]): TreeNode | null {
    const nodes: TreeNode[] = [];

    if (values.length == 0) {
      return null;
    }

    const root = new TreeNode(values.shift());
    nodes.push(root);

    while (nodes.length > 0) {
      const node = nodes.shift();

      if (node === undefined) {
        continue;
      }

      if (values.length > 0) {
        const left = new TreeNode(values.shift());

        node.left = left;

        nodes.push(left);
      }

      if (values.length > 0) {
        const right = new TreeNode(values.shift());

        node.right = right;

        nodes.push(right);
      }
    }

    return root;
  }

  static print(root: TreeNode | null): void {
    if (root === null) return;

    const nodes: TreeNode[] = [root];

    let i = 0;

    while (i < nodes.length) {
      const node = nodes[i];

      if (node.left != null) {
        nodes.push(node.left);
      }

      if (node.right != null) {
        nodes.push(node.right);
      }

      i++;
    }

    console.log(nodes.map(node => node.val));
  }
}


const values: number[] = [];

for (let i = 0; i < 31; i++) {
  values.push(i);
}

const root: TreeNode | null = TreeNode.from(values);

const getDepth = (node: TreeNode | null): number => node == null ? 0 : (getDepth(node.left) + 1);

function swap(left: TreeNode, right: TreeNode, depth: number) {
  if (depth % 2 == 0) {
    const t = left.val;
    left.val = right.val;
    right.val = t;
  }

  if (depth > 1) {
    swap(left.left!, right.right!, depth - 1);
    swap(left.right!, right.left!, depth - 1)
  }
}

function reverseOddLevels(root: TreeNode | null): TreeNode | null {
  if (!root) {
    return null;
  }

  const depth = getDepth(root);

  if (depth > 1) {
    swap(root.left!, root.right!, depth - 1);
  }

  return root;
};

reverseOddLevels(root);
TreeNode.print(root);
