import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(A);

        int count = 0;
        int i = 0; // A[0];
        int j = N - 1; // A[N - 1];
        while (i < j) {
            int point = A[i] + A[j];
            if (point < M) {
                i++;
            } else if (point > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
