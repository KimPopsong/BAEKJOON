import java.util.Scanner;

public class GoalOrderPossibilities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            
            if (A == -1 && B == -1) break;
            
            int possibilities = countPossibilities(A, B);
            int sum = A + B;
            
            if (possibilities == sum) {
                System.out.println(A + "+" + B + "=" + sum);
            } else {
                System.out.println(A + "+" + B + "!=" + sum);
            }
        }
        
        scanner.close();
    }
    
    public static int countPossibilities(int A, int B) {
        return binomialCoefficient(A + B, A);
    }
    
    public static int binomialCoefficient(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
