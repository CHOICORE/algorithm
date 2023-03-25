import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int line = 1;  // 해당 분수가 속한 대각선의 번호
        int count = 1;  // 대각선 상에 존재하는 분수의 개수
        while (x > count) {
            line++;
            count += line;
        }

        int diff = count - x;  // 해당 대각선에서 몇 번째 분수인지
        int numerator, denominator;
        if (line % 2 == 0) {  // 대각선 번호가 짝수인 경우
            numerator = line - diff;
            denominator = diff + 1;
        } else {  // 대각선 번호가 홀수인 경우
            numerator = diff + 1;
            denominator = line - diff;
        }

        System.out.println(numerator + "/" + denominator);
        sc.close();
    }
}
