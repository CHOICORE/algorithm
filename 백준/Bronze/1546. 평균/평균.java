import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static double solution(int length, int[] scores) {
        int max = 0;
        double sum = 0;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        for (int score : scores) {
            sum += ((double) score / max) * 100;
        }

        return sum / length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        scanner.nextLine();
        String input2 = scanner.nextLine();

        int[] scores = Arrays.stream(input2.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print(solution(input1, scores));
    }
}