import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.sun.nio.sctp.SendFailedNotification;

public class MaximumSquareAreaByRemovingFencesFromAField {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.maximizeSquareArea(
            4,
            3,
            new int[] { 2, 3 },
            new int[] { 2 }));

    System.out.println(
        solution.maximizeSquareArea(
            6,
            7,
            new int[] { 2, 3 },
            new int[] { 2 }));
  }
}

class Solution {
  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    var seen = new HashSet<Integer>();

    var hl = hFences.length + 2;
    var h = Arrays.copyOf(hFences, hl);
    h[hl - 2] = 1;
    h[hl - 1] = m;

    for (var i = 0; i < hl; i++) {
      for (var j = i + 1; j < hl; j++) {
        seen.add(Math.abs(h[i] - h[j]));
      }
    }

    var hv = vFences.length + 2;
    var v = Arrays.copyOf(vFences, hv);
    v[hv - 2] = 1;
    v[hv - 1] = n;

    var gap = 0l;

    for (var i = 0; i < hv; i++) {
      for (var j = i + 1; j < hv; j++) {
        var distance = Math.abs(v[i] - v[j]);

        if (seen.contains(distance)) {
          gap = Math.max(gap, distance);
        }
      }
    }

    if (gap == 0) {
      return -1;
    }

    return (int) ((gap * gap) % 1_000_000_007);
  }
}
