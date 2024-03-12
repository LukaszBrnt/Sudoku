import java.util.ArrayList;

public class Solver {

    public static void solveByFindLeastFreeFields(int[][] board) {
        System.out.println("Trying to solve");
        Assigner assigner = new Assigner();
        assigner.convertToRows(board);
        ArrayList<int[]> rows = assigner.getRowsInList();
        sortLeastFreeFields(rows);
    }

    private static void sortLeastFreeFields(ArrayList<int[]> rows) {
    }
}
