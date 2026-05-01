import java.util.LinkedList;

public class SumRootToLeafNumbers {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.sumNumbers(
            new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3))));

    System.out.println(
        solution.sumNumbers(
            new TreeNode(
                4,
                new TreeNode(
                    9,
                    new TreeNode(5),
                    new TreeNode(1)),
                new TreeNode(0))));
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
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }

    var sum = 0;
    var queue = new LinkedList<Object[]>();

    queue.offer(new Object[] { root, root.val });

    while (!queue.isEmpty()) {
      var objects = queue.poll();
      var node = (TreeNode) objects[0];
      var currentSum = (Integer) objects[1];

      if (node.left == null && node.right == null) {
        sum += currentSum;
        continue;
      }

      if (node.right != null) {
        queue.offer(new Object[] { node.right, currentSum * 10 + node.right.val });
      }

      if (node.left != null) {
        queue.offer(new Object[] { node.left, currentSum * 10 + node.left.val });
      }
    }

    return sum;
  }
}
