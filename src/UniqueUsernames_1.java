import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> nameDiary = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String names = scanner.nextLine();
            nameDiary.add(names);
        }
        nameDiary.forEach(System.out::println);
    }
}
