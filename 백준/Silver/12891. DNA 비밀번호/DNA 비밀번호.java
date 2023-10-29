import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] checkCountArr = new int[4];
    static int[] checkArr = new int[4];
    static int checkCount = 0;

    static int validSize = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer reader = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(reader.nextToken());
        int P = Integer.parseInt(reader.nextToken());
        char[] A = br.readLine().toCharArray();
        reader = new StringTokenizer(br.readLine());
        br.close();
        int answer = 0;
        for (int i = 0; i < validSize; i++) {
            checkArr[i] = Integer.parseInt(reader.nextToken());
            if (checkArr[i] == 0) {
                checkCount++;
            }
        }
        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        if (checkCount == validSize) {
            answer++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if (checkCount == validSize) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void remove(final char c) {
        switch (c) {
            case 'A':
                if (checkArr[0] == checkCountArr[0]) checkCount--;
                checkCountArr[0]--;
                break;
            case 'C':
                if (checkArr[1] == checkCountArr[1]) checkCount--;
                checkCountArr[1]--;
                break;
            case 'G':
                if (checkArr[2] == checkCountArr[2]) checkCount--;
                checkCountArr[2]--;
                break;
            case 'T':
                if (checkArr[3] == checkCountArr[3]) checkCount--;
                checkCountArr[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                checkCountArr[0]++;
                if (checkArr[0] == checkCountArr[0]) checkCount++;
                break;
            case 'C':
                checkCountArr[1]++;
                if (checkArr[1] == checkCountArr[1]) checkCount++;
                break;
            case 'G':
                checkCountArr[2]++;
                if (checkArr[2] == checkCountArr[2]) checkCount++;
                break;
            case 'T':
                checkCountArr[3]++;
                if (checkArr[3] == checkCountArr[3]) checkCount++;
                break;
        }
    }
}
