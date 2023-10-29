import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();
        int n = 1;
        int i = 0;
        while (i < list.length) {
            int current = list[i];
            if (current >= n) {
                while (current >= n) {
                    stack.push(n++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.pop() > current) {
                    sb = new StringBuffer("NO");
                    break;
                }
                sb.append("-\n");
            }
            i++;
        }
        System.out.println(sb);
    }
}
