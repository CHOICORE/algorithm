import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        int i = 0;
        StringBuffer sb = new StringBuffer();
        while (i < n) {
            sb.append(str);
            i++;
        }

        System.out.println(sb);
    }
}