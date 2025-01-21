import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(
                4,
                new TreeNode(5),
                null),
            null),
        new TreeNode(3));

    System.out.println(new Solution().rightSideView(root));
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
  void bfs(TreeNode node, int depth, List<Integer> rights) {
    if (node == null) {
      return;
    }

    if (depth == rights.size()) {
      rights.add(node.val);
    }

    if (node.right != null) {
      bfs(node.right, depth + 1, rights);
    }

    if (node.left != null) {
      bfs(node.left, depth + 1, rights);
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rights = new ArrayList<>();

    bfs(root, 0, rights);

    return rights;
  }
}
