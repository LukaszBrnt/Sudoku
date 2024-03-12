import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Assigner {
    private final ArrayList<int[]> rowsInList;

    public Assigner() {
        this.rowsInList = new ArrayList<>();
    }

    public void convertToRows(int[][] board) {
        for (int i = 0; i < 9; i++) {
            rowsInList.add(board[i]);
        }
        for (int i = 0; i < 9; i++) {
            int[] tempTab = new int[9];
            for (int j = 0; j < 9; j++) {
                tempTab[j] = board[j][i];
            }
            rowsInList.add(tempTab);
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] tempTab = new int[9];
                int index = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        tempTab[index++] = board[k][l];
                    }
                }
                rowsInList.add(tempTab);
            }
        }
    }

    public ArrayList<int[]> getRowsInList() {
        return rowsInList;
    }
}

