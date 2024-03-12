import java.util.*;

public class Sudoku {

    private int[][] board = new int[9][9];


    private long attemptsCounter;
    private int firstFillPercentage = 25;

    public Sudoku() {
    }

    public Sudoku(int firstFillPercentage) {
        super();
        this.firstFillPercentage = firstFillPercentage;
        setAttemptsCounter(0);
    }

    public long runner() {
        generateSudoku();
        long start = System.currentTimeMillis();
        randomizeSudoku();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private void randomizeSudoku() {
        boolean generatedCorrectly = false;
        int filledFieldsCounter = 81 * firstFillPercentage / 100;
        if (filledFieldsCounter < 17) {
            System.out.println("Filled level lower than possible, now it's 17");
            filledFieldsCounter = 17;
        }
        do {
            int counter = 0;
            int row = 9;
            int column = 0;
            List<Integer> shuffleArray = getShuffleArray();
            Random findRandom = new Random();
            do {
                if (row == 9) {
                    row = 0;
                    shuffleArray = getShuffleArray();
                }
                counter++;
                column = findRandom.nextInt(9);
                board[row][column] = shuffleArray.get(row);

                row++;
            } while (counter < filledFieldsCounter);

            if (!check(true)) {
                generateSudoku();
                incrementAttemptCounter();
            } else {
                generatedCorrectly = true;
                System.out.println("Sudoku start!");
                System.out.println("Generating level with " + filledFieldsCounter + " fields");
                System.out.println("Needed only: " + getAttemptsCounter() + " attempts.");
                printSudoku();
            }
        }while (!generatedCorrectly);
        setAttemptsCounter(0);
    }

    private void incrementAttemptCounter() {
        setAttemptsCounter(getAttemptsCounter()+1);
    }

    private List<Integer> getShuffleArray() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> shuffleArray = Arrays.asList(intArray);
        Collections.shuffle(shuffleArray);
        return shuffleArray;
    }

    private boolean validate(int tab[], boolean ignoreZero) {
        if (tab.length > 9) {
            System.out.println("ERROR - Length mismatch!");
            return false;
        }
        boolean existInTable = false;
        for (int n : tab) {
            if (!ignoreZero && n == 0) {
                return false;
            } else {
                for (int i = 0; i < 9; i++) {
                    if (n == tab[i] && n != 0) {
                        if (existInTable) {
                            return false;
                        }
                        existInTable = true;
                    }
                }
                existInTable = false;
            }
        }
        return true;
    }

    private boolean check(boolean ignoreZero) {
        Assigner assigner = new Assigner();
        assigner.convertToRows(board);
        for (int[] tab: assigner.getRowsInList()) {
                if (!validate(tab, ignoreZero)) {
                    return false;
                }
        }
        return true;
    }


    private void generateSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("+ - - - + - - - + - - - +");
            }
            for (int j = 0; j < 10; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                if (j != 9) {
                    System.out.print(board[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("+ - - - + - - - + - - - +");
        System.out.println("Printed Sudoku");
    }

    public long getAttemptsCounter() {
        return attemptsCounter;
    }

    public void setAttemptsCounter(long attemptsCounter) {
        this.attemptsCounter = attemptsCounter;
    }

    public int[][] getBoard() {
        return board;
    }
}
