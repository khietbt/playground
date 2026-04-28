import java.util.LinkedList;

public class PathSum {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.hasPathSum(
        new TreeNode(
            5,
            new TreeNode(
                4,
                new TreeNode(
                    11,
                    new TreeNode(7),
                    new TreeNode(2)),
                null),
            new TreeNode(
                8,
                new TreeNode(13),
                new TreeNode(
                    4,
                    null,
                    new TreeNode(1)))),
        22));

    System.out.println(
        solution.hasPathSum(
            new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)),
            5));
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
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    var queue = new LinkedList<Object[]>();

    queue.offer(new Object[] { root, 0 });

    while (!queue.isEmpty()) {
      var size = queue.size();

      for (var i = 0; i < size; i++) {
        var objects = queue.poll();

        var node = (TreeNode) objects[0];
        var accumulatedSum = (Integer) objects[1];
        var sum = accumulatedSum + node.val;

        if (node.left == null && node.right == null) {
          if (sum == targetSum) {
            return true;
          }

          continue;
        }

        if (node.left != null) {
          queue.push(new Object[] { node.left, sum });
        }

        if (node.right != null) {
          queue.push(new Object[] { node.right, sum });
        }
      }
    }

    return false;
  }
}
