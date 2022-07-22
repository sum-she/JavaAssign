import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word ");
        String s = scanner.nextLine();
        System.out.println("Enter 3 numbers: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();


        fibonacci(n1);
        checkPrime(n1);
        sum(n1, n2, n2);
        swap(n1, n2);
        reverse(s);
    }

    //print Fibonacci Series
    static void fibonacci(int n1) {
        int[] fib = new int[n1];
        fib[0] = 0;
        fib[1] = 1;
        System.out.print("Fibonacci series: " + fib[0] + ", " + fib[1]);

        for (int i = 2; i < n1; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
            System.out.print(", " + fib[i]);
        }
        System.out.println();
    }

    //check if user input is a prime number
    static void checkPrime(int n1) {

        for (int i = 2; i < n1; i++) {
            if (n1 <= 1) {
                System.out.println(n1 + " is not a prime number");
            } else if (n1 % i == 0) {
                System.out.println(n1 + " is not a prime number");
                return;
            }
        }
        System.out.println(n1 + " is a prime number");
    }

    //swap variables
    static void swap(int n1, int n2) {
        System.out.print("After swapping " + n1 + " and " + n2 + ", ");
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
        System.out.println("they become " + n1 + " and " + n2);
    }

    //calculate sum
    static void sum(int n1, int n2, int n3) {
        System.out.print(n1 + " + " + n2 + " = " + n3 + ", is ");
        System.out.println(n1 + n2 == n3);
    }

    //reverse a word
    static void reverse(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(i));
                break;
            }
        }
    }
}