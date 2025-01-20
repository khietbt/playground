import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathSumIII {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        1000000000,
        new TreeNode(),
        null);

    System.out.println(new Solution().pathSum(root, 0));
    // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
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
  Map<TreeNode, Set<Integer>> seen = new HashMap<>();

  int pathSum(TreeNode node, int target, int accumulated, int depth) {
    if (node == null) {
      return 0;
    }

    // System.out.println(target + ", " + accumulated + ", " + node.val + ", " +
    // (accumulated + node.val));

    accumulated += node.val;

    int totalPaths = (accumulated == target ? 1 : 0);

    if (node.left != null) {
      Set<Integer> seenDepths = seen.getOrDefault(node.left, new HashSet<>());

      if (!seenDepths.contains(0)) {
        totalPaths += pathSum(node.left, target, 0, 0);
        seenDepths.add(0);
      }

      if (!seenDepths.contains(depth + 1)) {
        totalPaths += pathSum(node.left, target, accumulated, depth + 1);

        seenDepths.add(depth + 1);
      }

      seen.put(node.left, seenDepths);
    }

    if (node.right != null) {
      Set<Integer> seenDepths = seen.getOrDefault(node.right, new HashSet<>());

      if (!seenDepths.contains(0)) {
        totalPaths += pathSum(node.right, target, 0, 0);
        seenDepths.add(0);
      }

      if (!seenDepths.contains(depth + 1)) {
        totalPaths += pathSum(node.right, target, accumulated, depth + 1);

        seenDepths.add(depth + 1);
      }

      seen.put(node.right, seenDepths);
    }

    return totalPaths;
  }

  public int pathSum(TreeNode root, int target) {
    return pathSum(root, target, 0, 0);
  }
}
