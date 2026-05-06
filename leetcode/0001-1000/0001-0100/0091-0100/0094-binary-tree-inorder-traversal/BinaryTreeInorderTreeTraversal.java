import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    var stack = new Stack<TreeNode>();
    var node = root;

    var result = new ArrayList<Integer>();

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);

        node = node.left;
      }

      node = stack.pop();

      result.add(node.val);

      node = node.right;
    }

    return result;
  }
}
