import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseOddLevelsOfBinaryTree {
  public static void main(String[] args) {
    int[] values = new int[31];

    for (int i = 0; i < 31; i++) {
      values[i] = i + 1;
    }

    TreeNode root = TreeNode.fromValues(values);

    TreeNode.print(root);

    System.out.println("****************************************************************************************");

    Solution s = new Solution();

    TreeNode.print(s.reverseOddLevels(root));
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

  static TreeNode fromValues(int[] values) {
    if (values.length < 1) {
      return null;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();

    TreeNode root = new TreeNode(values[0]);

    deque.offerLast(root);

    int i = 1;

    while (i < values.length) {
      TreeNode current = deque.poll();

      TreeNode left = new TreeNode(values[i]);
      TreeNode right = new TreeNode(values[i + 1]);

      current.left = left;
      current.right = right;

      deque.offerLast(left);
      deque.offerLast(right);

      i = i + 2;
    }

    return root;
  }

  static void print(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<>();

    deque.offer(root);

    while (!deque.isEmpty()) {
      TreeNode node = deque.poll();

      if (node != null) {
        System.out.println(node.val);

        if (node.left != null)
          deque.offerLast(node.left);

        if (node.right != null)
          deque.offerLast(node.right);
      }
    }
  }
}

class Solution {
  public TreeNode reverseOddLevels(TreeNode root) {
    int level = 0;
    int i = 0;

    Deque<TreeNode> queue = new ArrayDeque<>();
    Deque<TreeNode> nextQueue = new ArrayDeque<>();

    queue.offerLast(root);

    if (root.left != null) {
      nextQueue.offerLast(root.left);
      nextQueue.offerLast(root.right);
    }

    while (!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();

      if (nextQueue.isEmpty()) {
        node.left = null;
        node.right = null;

        continue;
      }

      if (level % 2 == 0) {
        TreeNode left = nextQueue.pollLast();
        TreeNode right = nextQueue.pollLast();

        node.left = left;
        node.right = right;

        queue.offerLast(left);
        queue.offerLast(right);

        if (left.left != null) {
          nextQueue.offerFirst(left.right);
          nextQueue.offerFirst(left.left);
          nextQueue.offerFirst(right.right);
          nextQueue.offerFirst(right.left);
        }
      } else {
        TreeNode left = nextQueue.pollFirst();
        TreeNode right = nextQueue.pollFirst();

        node.left = left;
        node.right = right;

        queue.offerLast(left);
        queue.offerLast(right);

        if (left.left != null) {
          nextQueue.offerLast(left.left);
          nextQueue.offerLast(left.right);
          nextQueue.offerLast(right.left);
          nextQueue.offerLast(right.right);
        }
      }

      i++;

      if (i == ((1 << (level + 1)) - 1)) {
        level++;
      }
    }

    return root;
  }
}
