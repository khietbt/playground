public class LowestCommonAncestorOfABinaryTree {
  public static void main(String[] args) {
    //
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null || node == p || node == q) {
      return node;
    }

    TreeNode left = lowestCommonAncestor(node.left, p, q);
    TreeNode right = lowestCommonAncestor(node.right, p, q);

    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    return node;
  }
}
