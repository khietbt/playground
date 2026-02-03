public class NumberOfPeopleAwareOfASecret {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.peopleAwareOfSecret(
            6,
            2,
            4));
  }
}

class Solution {
  public int peopleAwareOfSecret(int n, int delay, int forget) {
    var MODULO = 1_000_000_007L;
    var totalPeopleKnowingTheSecret = 1L;

    var shareables = new long[n];
    shareables[0] = 1L;

    var shareable = 0L;

    for (var i = 1; i < n; i++) {
      var shared = (i >= delay) ? shareables[i - delay] : 0L;
      var forgot = (i >= forget) ? shareables[i - forget] : 0L;

      // Number of people who can share the secret at the (i + delay)-th day
      shareable = (shareable + shared - forgot + MODULO) % MODULO;
      shareables[i] = shareable;

      // total people who know the secret at the i + 1 day.
      totalPeopleKnowingTheSecret = (totalPeopleKnowingTheSecret + shareable - forgot + MODULO) % MODULO;
    }

    return (int) (totalPeopleKnowingTheSecret % MODULO);
  }
}
