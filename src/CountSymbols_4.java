import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbols = input.charAt(i);
            if (!symbolsMap.containsKey(symbols)) {
                symbolsMap.put(symbols, 1);
            } else {
                //тука взимаме моментния брой срещания
                //и подновяваме мапа
                int currentSymbol = symbolsMap.get(symbols);
                symbolsMap.put(symbols, ++currentSymbol);//++ го слагаме отпред защото първо
                // трябва да увеличаваме стойноста и след това я увеличаваме
            }
        }
        for (Map.Entry<Character, Integer> entry : symbolsMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());

        }
    }
}
