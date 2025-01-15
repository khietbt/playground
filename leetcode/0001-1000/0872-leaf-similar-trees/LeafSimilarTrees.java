import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class LeafSimilarTrees {
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
  public boolean leafSimilar(TreeNode lhs, TreeNode rhs) {
    Function<TreeNode, TreeNode[]> getLeaves = (root) -> {
      if (root == null) {
        return new TreeNode[] {};
      }

      List<TreeNode> leaves = new ArrayList<>();

      Deque<TreeNode> queue = new LinkedList<>();

      queue.offer(root);

      while (!queue.isEmpty()) {
        TreeNode node = queue.pollFirst();

        if (node.left == null && node.right == null) {
          leaves.add(node);
        }

        if (node.right != null) {
          queue.offerFirst(node.right);
        }

        if (node.left != null) {
          queue.offerFirst(node.left);
        }
      }

      return leaves.toArray(TreeNode[]::new);
    };

    TreeNode[] lefts = getLeaves.apply(lhs);
    TreeNode[] rights = getLeaves.apply(rhs);

    if (lefts.length != rights.length) {
      return false;
    }

    for (int i = 0; i < lefts.length; i++) {
      if (lefts[i].val != rights[i].val) {
        return false;
      }
    }
    //
    return true;
  }
}
