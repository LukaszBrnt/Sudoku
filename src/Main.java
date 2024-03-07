import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sudoku Example");
        Scanner scanner = new Scanner(System.in);
        int input=0;
        do {
            System.out.println("Percentage filling of Sudoku? - ");
            try {
                input = parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
                input = 90;
            }
        }while (input > 81);
        Sudoku sudoku = new Sudoku(input);
        sudoku.runner();
    }


}