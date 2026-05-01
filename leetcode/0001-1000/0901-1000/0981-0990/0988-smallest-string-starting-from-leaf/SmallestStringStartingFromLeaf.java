import java.util.LinkedList;

public class SmallestStringStartingFromLeaf {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.smallestFromLeaf(
            new TreeNode(
                0,
                new TreeNode(
                    1,
                    new TreeNode(3),
                    new TreeNode(4)),
                new TreeNode(
                    2,
                    new TreeNode(3),
                    new TreeNode(4)))));

    System.out.println(
        solution.smallestFromLeaf(
            new TreeNode(
                3,
                new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
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
  public String smallestFromLeaf(TreeNode root) {
    var queue = new LinkedList<Object[]>();
    var smallest = "";

    queue.offer(new Object[] { root, String.valueOf((char) (root.val + 97)) });

    while (!queue.isEmpty()) {
      var objects = queue.poll();
      var node = (TreeNode) objects[0];
      var path = (String) objects[1];

      if (node.left == null && node.right == null) {
        if (smallest.isEmpty() || smallest.compareTo(path) > 0) {
          smallest = path;
        }

        continue;
      }

      if (node.right != null) {
        queue.offer(new Object[] { node.right, (char) (node.right.val + 97) + path });
      }

      if (node.left != null) {
        queue.offer(new Object[] { node.left, (char) (node.left.val + 97) + path });
      }
    }

    return smallest;
  }
}
