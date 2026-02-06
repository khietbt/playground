import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // solution.minimumTeachings(
    // 2, new int[][] { { 1 }, { 2 }, { 1, 2 } },
    // new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));

    System.out.println(
        solution.minimumTeachings(
            5, new int[][] {
                { 1 }, { 5 }, { 1, 5 }, { 5 }
            },
            new int[][] {
                { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }
            }));
  }
}

class Solution {
  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
    var users = new HashSet<>();

    var data = new HashMap<Integer, Set<Integer>>();

    for (var i = 0; i < languages.length; i++) {
      var s = new HashSet<Integer>();
      for (var l : languages[i]) {
        s.add(l);
      }

      data.put(i, s);
    }

    for (var f : friendships) {
      var first = f[0] - 1;
      var second = f[1] - 1;

      if (data.get(first).stream().anyMatch(l -> data.get(second).contains(l))) {
        continue;
      }

      users.add(first);
      users.add(second);
    }

    // System.out.println(users.toString());

    var minimum = Integer.MAX_VALUE;

    for (var l = 1; l <= n; l++) {
      var current = users.size();

      for (var u : users) {
        if (data.get(u).contains(l)) {
          current--;
        }
      }

      System.out.println("l = " + l + ", current = " + current);

      minimum = Math.min(minimum, current);
    }

    return minimum;
  }
}
