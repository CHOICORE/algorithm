import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        // 연속된 홀수개의 자연수로 표현하는 경우
        for (int i = 1; i * i <= 2 * n; i += 2) {
            if (n % i == 0) {
                count++;
            }
        }

        // 연속된 짝수개의 자연수로 표현하는 경우
        for (int i = 2; i * i <= 2 * n; i += 2) {
            if (n % i == i / 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}