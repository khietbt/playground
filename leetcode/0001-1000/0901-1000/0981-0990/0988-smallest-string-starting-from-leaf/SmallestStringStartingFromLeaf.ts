// import {PriorityQueue} from "@data"
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

function smallestFromLeaf(root: TreeNode | null): string {
  let smallest = "zzzzzzzzzzzz";

  if (root == null) {
    return "";
  }

  let queue: [TreeNode, string][] = [
    [root, String.fromCharCode(root.val + 97)],
  ];

  while (queue.length > 0) {
    const newQueue: [TreeNode, string][] = [];

    while (queue.length > 0) {
      const [node, accumulated] = queue.shift()!;

      if (node.left == null && node.right == null) {
        smallest =
          smallest.localeCompare(accumulated) > 0 ? accumulated : smallest;
      }

      if (node.left != null) {
        const s = String.fromCharCode(node.left.val + 97) + accumulated;
        newQueue.push([node.left, s]);
      }

      if (node.right != null) {
        const s = String.fromCharCode(node.right.val + 97) + accumulated;
        newQueue.push([node.right, s]);
      }
    }

    queue = newQueue;
  }

  return smallest;
}

console.log(
  smallestFromLeaf(
    new TreeNode(
      2,
      new TreeNode(2, null, new TreeNode(1, new TreeNode(0))),
      new TreeNode(1, new TreeNode(0)),
    ),
  ),
);

// console.log(
//   smallestFromLeaf(
//     new TreeNode(
//       25,
//       new TreeNode(1, new TreeNode(1), new TreeNode(3)),
//       new TreeNode(3, new TreeNode(0), new TreeNode(2)),
//     ),
//   ),
// );
//
// [3,9,20,null,null,15,7]

console.log(
  smallestFromLeaf(
    new TreeNode(
      3,
      new TreeNode(9),
      new TreeNode(20, new TreeNode(15), new TreeNode(7)),
    ),
  ),
);
