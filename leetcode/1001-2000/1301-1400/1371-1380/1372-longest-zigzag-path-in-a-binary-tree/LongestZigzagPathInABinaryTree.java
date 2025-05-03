public class LongestZigzagPathInABinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode();
    System.out.println(new Solution().longestZigZag(root));
  }
}

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
  int longestZigZag(TreeNode node, int length, boolean isLeft) {
    if (node == null) {
      return length;
    }

    if (isLeft) {
      return Math.max(longestZigZag(node.left, 0, true), longestZigZag(node.right, length + 1, false));
    }

    return Math.max(longestZigZag(node.left, length + 1, true), longestZigZag(node.right, 0, false));
  }

  public int longestZigZag(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(longestZigZag(root.left, 0, true), longestZigZag(root.right, 0, false));
  }
}
