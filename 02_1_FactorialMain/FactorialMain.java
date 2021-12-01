import java.util.Scanner;

public class FactorialMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        for(int i = 1; i <= num; i++){
            System.out.println("Factorial of " + i + " = " + getFactorial(i));
        }
    }
    private static long getFactorial(final int n){
        if (n == 1) return 1;
        int Factorial = 1;
        for (int i = 2; i <= n; i++){
            Factorial *= i;
        }
        return Factorial;
    }
}
