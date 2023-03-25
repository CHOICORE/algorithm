import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int answer = 1;
            for (int i = 1; i <= N; i++) {
                answer *= M - N + i;
                answer /= i;
            }
            System.out.println(answer);
        }
        sc.close();
    }
}
