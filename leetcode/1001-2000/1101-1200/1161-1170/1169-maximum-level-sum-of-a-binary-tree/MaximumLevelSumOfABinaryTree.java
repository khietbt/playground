import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumOfABinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        1,
        new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
        new TreeNode(0));

    System.out.println(new Solution().maxLevelSum(root));
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
  void sum(TreeNode node, int depth, List<Long> sums) {
    if (sums.size() == depth) {
      sums.add((long) node.val);
    } else {
      sums.set(depth, sums.get(depth) + node.val);
    }

    if (node.left != null) {
      sum(node.left, depth + 1, sums);
    }

    if (node.right != null) {
      sum(node.right, depth + 1, sums);
    }
  }

  public int maxLevelSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    List<Long> sums = new ArrayList<>();

    sum(root, 0, sums);

    int maxLevelSum = 0;
    long maxSum = sums.get(0);

    for (int i = 1; i < sums.size(); i++) {
      if (maxSum < sums.get(i)) {
        maxSum = sums.get(i);
        maxLevelSum = i;
      }
    }

    return maxLevelSum + 1;
  }
}
