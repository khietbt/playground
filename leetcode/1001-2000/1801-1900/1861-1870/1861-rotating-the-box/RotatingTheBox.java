import java.util.Arrays;

public class RotatingTheBox {

  public static void main(String[] args) {
    var solution = new Solution();

    var boxGrid = new char[][] {
        { '#', '#', '*', '#', '.', '*', '.' },
        { '#', '#', '#', '*', '#', '.', '.' },
        { '#', '#', '#', '.', '#', '*', '.' },
    };

    Arrays.stream(boxGrid).forEach(r -> System.out.println(Arrays.toString(r)));

    System.out.println();
    System.out.println();

    var dropped = solution.rotateTheBox(boxGrid);

    Arrays.stream(dropped).forEach(r -> System.out.println(Arrays.toString(r)));
  }
}

class Solution {
  public char[][] rotateTheBox(char[][] boxGrid) {
    var m = boxGrid.length;
    var n = boxGrid[0].length;

    var rotatedBox = new char[n][m];

    for (var i = 0; i < m; i++) {
      var shift = 0;

      for (var j = n - 1; j >= 0; j--) {

        switch (boxGrid[i][j]) {
          case '#':
            rotatedBox[j][m - 1 - i] = '.';
            rotatedBox[j + shift][m - 1 - i] = '#';
            break;

          case '.':
            rotatedBox[j][m - 1 - i] = '.';
            shift++;
            break;

          case '*':
            rotatedBox[j][m - 1 - i] = '*';
            shift = 0;
            break;
        }
      }
    }

    return rotatedBox;
  }
}
