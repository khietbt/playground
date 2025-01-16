public class CanPlaceFlowers {
  public static void main(String[] args) {
    final int[] flowerbed = { 1, 0, 0, 0, 1, 0, 0 };
    final int n = 2;

    System.out.println((new Solution()).canPlaceFlowers(flowerbed, n));
  }
}

class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int extra = 0;
    int length = flowerbed.length;

    for (int i = 0; i < length && extra < n; i++) {
      int left = i == 0 ? 0 : flowerbed[i - 1];
      int right = i == length - 1 ? 0 : flowerbed[i + 1];

      if (right + left + flowerbed[i] == 0) {
        flowerbed[i] = 1;

        extra++;
      }
    }

    return extra >= n;
  }
}
