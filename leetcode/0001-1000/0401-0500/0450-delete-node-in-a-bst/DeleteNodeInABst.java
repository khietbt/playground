public class DeleteNodeInABst {
  public static void main(String[] args) {
    //
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
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      TreeNode mostLeft = mostLeft(root.right);

      root.right = deleteNode(root.right, mostLeft.val);

      mostLeft.left = root.left;
      mostLeft.right = root.right;

      return mostLeft;
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }

    return root;
  }

  TreeNode mostLeft(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }

    return node;
  }
}
