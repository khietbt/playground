import java.util.ArrayList;
import java.util.List;

public class FruitsIntoBasketsII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.numOfUnplacedFruits(
            new int[] { 4, 2, 6 }, new int[] { 3, 5, 4 }));

    System.out.println(
        solution.numOfUnplacedFruits(
            new int[] { 2, 16, 53, 100, 61 }, new int[] { 46, 7, 78, 30, 30 }));
  }
}

class Solution {

  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    var totalBaskets = baskets.length;
    var segmentSize = (int) Math.sqrt(totalBaskets);
    var totalSegments = (totalBaskets + segmentSize - 1) / segmentSize;
    var segmentMaximums = new ArrayList<Integer>();

    var segments = new ArrayList<List<Integer>>();
    for (var i = 0; i < totalSegments; i++) {
      segments.add(new ArrayList<>());
      segmentMaximums.add(0);
    }

    for (var i = 0; i < totalBaskets; i++) {
      var segmentIndex = i / segmentSize;

      segments.get(segmentIndex).add(baskets[i]);
      segmentMaximums.set(segmentIndex, Math.max(segmentMaximums.get(segmentIndex), baskets[i]));
    }

    var unplaced = 0;

    for (var fruit : fruits) {
      var selectedSegmentIndex = -1;

      for (var i = 0; i < segmentMaximums.size(); i++) {
        if (segmentMaximums.get(i) >= fruit) {
          selectedSegmentIndex = i;
          break;
        }
      }

      if (selectedSegmentIndex == -1) {
        unplaced++;
        continue;
      }

      var selectedBasketIndex = -1;

      var segment = segments.get(selectedSegmentIndex);

      for (var i = 0; i < segment.size(); i++) {
        if (segment.get(i) >= fruit) {
          selectedBasketIndex = i;
          break;
        }
      }

      if (selectedBasketIndex == -1) {
        unplaced++;
        continue;
      }

      segment.remove(selectedBasketIndex);

      if (segment.size() == 0) {
        segments.remove(selectedSegmentIndex);
        segmentMaximums.remove(selectedSegmentIndex);
      } else {
        segmentMaximums.set(
            selectedSegmentIndex,
            segment.stream().max((a, b) -> a - b).orElse(0));
      }
    }

    return unplaced;
  }
}
