import java.util.PriorityQueue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    var queue = new PriorityQueue<Object[]>((a, b) -> {
      var heightA = (Integer) a[1];
      var heightB = (Integer) b[1];

      return Integer.compare(heightA, heightB);
    });

    queue.offer(new Object[] { root, 1 });

    while (!queue.isEmpty()) {
      var objects = (Object[]) queue.poll();
      var node = (TreeNode) objects[0];
      var height = (Integer) objects[1];

      if (node.left == null && node.right == null) {
        return height;
      }

      if (node.left != null) {
        queue.offer(new Object[] { node.left, height + 1 });
      }

      if (node.right != null) {
        queue.offer(new Object[] { node.right, height + 1 });
      }
    }

    return 1;
  }
}
