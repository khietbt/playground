import java.util.PriorityQueue;

class SmallestInfiniteSet {
  PriorityQueue<Integer> queue;
  int smallest;

  public SmallestInfiniteSet() {
    queue = new PriorityQueue<>();
    smallest = 1;
  }

  public int popSmallest() {
    if (!queue.isEmpty()) {
      if (queue.peek() < smallest) {
        return queue.poll();
      }
    }

    return smallest++;
  }

  public void addBack(int num) {
    if (num < smallest) {
      queue.offer(smallest);
    }
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
