import java.util.Scanner;

public class MathMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a begin number: ");
        int begin = scanner.nextInt();
        System.out.println("Enter an end number: ");
        int end   = scanner.nextInt();
        scanner.close();
        long sum  = getSumBetween(begin, end);
        System.out.printf("Sum between %d and %d : %,d%n", begin, end, sum);

        long product = getProductBetween(begin, end);
        System.out.printf("Product between %d and %d : %,d%n", begin, end, product);

    }
    private static long getSumBetween(int begin_n, int end_n){
        long sum = 0;
        for (int i = begin_n; i <= end_n; i++)  sum += i;
        return sum;
    }
    private static long getProductBetween(int begin_n, int end_n){
        long product = 1;
        for (int i = begin_n; i <= end_n; i++)  product *= i;
        return product;
    }
}
