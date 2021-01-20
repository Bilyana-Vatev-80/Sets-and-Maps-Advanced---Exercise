import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int firstLine = input[0];
        int secondLine = input[1];

        Set<Integer> firstSet = new LinkedHashSet<>(firstLine);
        Set<Integer> secondSet = new LinkedHashSet<>(secondLine);


        for (int i = 0; i < firstLine; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            firstSet.add(numbers);
        }

        for (int i = 0; i < secondLine; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            secondSet.add(numbers);
        }
        firstSet.retainAll(secondSet);
        // firstSet ->взима само елементите, които ги има в другия secondSet
        // обхожда всички елементи тези които ги няма тази функция ги премахва
        firstSet.forEach(n -> System.out.print(n + " "));
    }
}
