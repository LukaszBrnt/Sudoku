public class Solver {

    public static void solveByFindLeastFreeFields(int[][] board) {
        System.out.println("Trying to solve");
        Assigner assigner = new Assigner();
        assigner.convertToRows(board);
    }
}
