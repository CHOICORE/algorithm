import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuilder sb = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (isLower(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb);
    }

    public static boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }
}