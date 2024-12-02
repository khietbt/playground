class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0;
        int n = sentence.length();
        int w = 1;

        while (i < n) {
            int j = i;
            int m = i + searchWord.length();

            if (m > n) {
                break;
            }

            while (j < m) {
                if (sentence.charAt(j) != searchWord.charAt(j - i)) {
                    break;
                }

                j++;
            }

            if (j == m) {
                return w;
            }

            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }

            i++;
            w++;
        }

        return -1;
    }
}

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] arguments) {
        System.out.println((new Solution()).isPrefixOfWord("i love eating burger", "burg"));
    }
}
