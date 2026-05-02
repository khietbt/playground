import java.util.ArrayList;

public class PopulatingNextRightPointersInEachNode {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println();
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

class Solution {
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    var queue = new ArrayList<Node>();

    queue.add(root);

    while (!queue.isEmpty()) {
      var newQueue = new ArrayList<Node>();

      // Link nodes at the current level.
      for (var i = 0; i < queue.size() - 1; i++) {
        var node = queue.get(i);
        var next = queue.get(i + 1);

        node.next = next;
      }

      for (var node : queue) {
        if (node.left != null) {
          newQueue.add(node.left);
        }

        if (node.right != null) {
          newQueue.add(node.right);
        }
      }

      // Next round
      queue = newQueue;
    }

    return root;
  }
}
