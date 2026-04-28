import java.util.Stack;

public class LongestValidParentheses {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.longestValidParentheses("(()"));
    System.out.println(solution.longestValidParentheses("()(()"));
    System.out.println(solution.longestValidParentheses("()(())"));
  }
}

class Solution {
  public int longestValidParentheses(String s) {
    var stack = new Stack<Integer>();
    stack.push(-1);

    var maximum = 0;

    for (var i = 0; i < s.length(); i++) {
      var c = s.charAt(i);

      if (c == '(') {
        stack.push(i);
      } else {
        stack.pop();

        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maximum = Math.max(maximum, i - stack.peek());
        }
      }
    }

    return maximum;
  }
}
