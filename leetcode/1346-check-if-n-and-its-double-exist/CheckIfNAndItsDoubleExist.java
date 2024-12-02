class Solution {
    public boolean checkIfExist(int[] a) {
        int[] cache = new int[2000 * 2 + 1];

        for (int i = 0; i < a.length; i++) {
            // int currentValue = a[i];

            if (cache[a[i] * 2 + 2000] != 0 || (a[i] % 2 == 0 && cache[a[i] / 2 + 2000] != 0)) {
                return true;
            }

            cache[a[i] + 2000] = i + 1;
        }

        return false;
    }
}

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] arguments) {
        // int[] a = { 0, 0 };
        // int[] a = { 10, 2, -5, 3 };
        int[] a = { -1, 2, 0, -4 };

        System.out.println((new Solution()).checkIfExist(a));
    }
}