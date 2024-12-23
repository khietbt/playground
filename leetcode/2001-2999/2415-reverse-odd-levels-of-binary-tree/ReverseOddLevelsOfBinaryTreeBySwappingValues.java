import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTreeBySwappingValues {
  public static void main(String[] args) {
    int[] values = new int[31];

    for (int i = 0; i < 31; i++) {
      values[i] = i;
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
    List<TreeNode> nodes = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      nodes.add(node);

      if (node.left != null) {
        queue.add(node.left);
        queue.add(node.right);
      }
    }

    for (int i = 0, level = 0, n = 1, start = 0, mid = 0; i < nodes.size(); i++) {
      if (level % 2 == 1 && i >= mid) {
        TreeNode right = nodes.get(i);
        TreeNode left = nodes.get(mid - (i - mid) - 1);

        int t = right.val;
        right.val = left.val;
        left.val = t;
      }

      if (i == start + n - 1) {
        level++;
        n = 1 << level;
        start = (1 << level) - 1;
        mid = start + n / 2;
      }
    }

    return root;
  }
}
