import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String integer = sc.nextLine();
        System.out.println(integer.chars()
                .map(Character::getNumericValue)
                .sum());
    }
}