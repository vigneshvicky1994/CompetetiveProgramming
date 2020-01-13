import java.util.Scanner;

public class SumOfSquares {
    public SumOfSquares() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        printSumOfSquares(num);
    }

    private static void printSumOfSquares(int num) {
        System.out.println(recurseSquare(num));
    }

    private static int recurseSquare(int num) {
        return num <= 0 ? 0 : num * num + recurseSquare(num - 1);
    }
}
