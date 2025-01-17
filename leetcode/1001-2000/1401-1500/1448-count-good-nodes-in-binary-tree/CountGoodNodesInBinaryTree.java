public class CountGoodNodesInBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);

    System.out.println(new Solution().goodNodes(root));
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
  int goodNodes(TreeNode node, int max) {
    if (node == null) {
      return 0;
    }

    return (node.val >= max ? 1 : 0) + goodNodes(node.left, Math.max(max, node.val))
        + goodNodes(node.right, Math.max(max, node.val));
  }

  public int goodNodes(TreeNode root) {
    return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
  }
}
