class Solution {
    public boolean checkIfExist(int[] a) {
        int[] cache = new int[2000 * 2 + 1];

        for (int i = 0; i < a.length; i++) {
            cache[a[i] + 1000] = i + 1;
        }

        for (int i = 0; i < a.length; i++) {
            int doubleValue = a[i] * 2;

            int index = cache[doubleValue + 1000];

            if (index != 0 && index != i + 1) {
                return true;
            }
        }

        return false;
    }
}

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] arguments) {
        // int[] a = { 0, 0 };
        int[] a = { 10, 2, 5, 3 };
        // int[] a = { -1, 2, 0, -4 };

        System.out.println((new Solution()).checkIfExist(a));
    }
}