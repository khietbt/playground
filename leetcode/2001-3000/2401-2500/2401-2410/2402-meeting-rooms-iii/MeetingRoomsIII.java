import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(solution.mostBooked(2, new int[][] { { 0, 10 }, { 1, 5 },
    // { 2, 7 }, { 3, 4 } }));
    // System.out.println(solution.mostBooked(3, new int[][] { { 1, 20 }, { 2, 10 },
    // { 3, 5 }, { 4, 9 }, { 6, 8 } }));
    // System.out.println(solution.mostBooked(2, new int[][] { { 0, 10 }, { 1, 2 },
    // { 12, 14 }, { 13, 15 } }));
    System.out.println(solution.mostBooked(4, new int[][] { { 18, 19 }, { 3, 12 }, { 17, 19 }, { 2, 13 }, { 7, 10 } }));
  }
}

class Solution {
  public int mostBooked(int n, int[][] meetings) {

    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

    PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1]; // Sort by room number if end times are equal
      }

      return a[0] - b[0]; // Sort by end time
    });

    PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

    for (var roomId = 0; roomId < n; roomId++) {
      availableRooms.offer(roomId);
    }

    var meetingCount = new int[n];

    for (var meeting : meetings) {
      var startTime = meeting[0];
      var endTime = meeting[1];

      while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= startTime) {
        var finishedRoom = busyRooms.poll();

        availableRooms.offer(finishedRoom[1]);
      }

      int assignedRoom;

      if (!availableRooms.isEmpty()) {
        assignedRoom = availableRooms.poll();

        busyRooms.offer(new int[] { endTime, assignedRoom });
      } else {
        var earliestRoom = busyRooms.poll();

        assignedRoom = earliestRoom[1];

        int delayedEndTime = earliestRoom[0] + (endTime - startTime);

        busyRooms.offer(new int[] { delayedEndTime, assignedRoom });
      }

      meetingCount[assignedRoom]++;
    }

    int mostUsedRoom = 0;

    for (int roomId = 0; roomId < n; roomId++) {
      if (meetingCount[roomId] > meetingCount[mostUsedRoom]) {
        mostUsedRoom = roomId;
      }
    }

    return mostUsedRoom;
  }
}
