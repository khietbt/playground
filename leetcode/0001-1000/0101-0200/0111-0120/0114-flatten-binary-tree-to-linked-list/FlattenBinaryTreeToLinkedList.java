import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

  public static void main(String[] args) {
    // var solution = new Solution();
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
  public void flatten(TreeNode root) {
    var stack = new Stack<TreeNode>();
    var node = new TreeNode();
    stack.push(root);

    while (!stack.isEmpty()) {
      var currentNode = stack.pop();

      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }

      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }

      node.right = currentNode;

      node = node.right;

      node.left = null;
      node.right = null;
    }
  }
}
