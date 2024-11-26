package exercise_3;

import java.util.*;

public class StringAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строк
        System.out.println("Введите первую строку:");
        String firstString = scanner.nextLine();

        System.out.println("Введите вторую строку:");
        String secondString = scanner.nextLine();

        // Частотный анализ
        Map<Character, Integer> frequencyFirst = calculateFrequency(firstString);
        Map<Character, Integer> frequencySecond = calculateFrequency(secondString);

        System.out.println("Частотный анализ первой строки: " + frequencyFirst);
        System.out.println("Частотный анализ второй строки: " + frequencySecond);

        // Наборы символов
        Set<Character> setFirst = new HashSet<>();
        for (char c : firstString.toCharArray()) {
            setFirst.add(c);
        }

        Set<Character> setSecond = new HashSet<>();
        for (char c : secondString.toCharArray()) {
            setSecond.add(c);
        }

        // Символы в обеих строках
        Set<Character> intersection = new HashSet<>(setFirst);
        intersection.retainAll(setSecond);

        // Символы только в первой строке
        Set<Character> onlyInFirst = new HashSet<>(setFirst);
        onlyInFirst.removeAll(setSecond);

        // Символы хотя бы в одной строке
        Set<Character> union = new HashSet<>(setFirst);
        union.addAll(setSecond);

        // Вывод результатов
        System.out.println("\nСимволы в обеих строках:");
        printInOrders(intersection);

        System.out.println("\nСимволы только в первой строке:");
        printInOrders(onlyInFirst);

        System.out.println("\nСимволы хотя бы в одной строке:");
        printInOrders(union);

        scanner.close();
    }

    // Метод для вычисления частоты символов
    public static Map<Character, Integer> calculateFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }

    // Метод для вывода символов в разных порядках
    public static void printInOrders(Set<Character> set) {
        // Обычный порядок
        System.out.println("Обычный порядок: " + set);

        // Обратный порядок
        List<Character> reversed = new ArrayList<>(set);
        Collections.reverse(reversed);
        System.out.println("Обратный порядок: " + reversed);

        // Порядок по возрастанию циклического сдвига хеш-функции
        List<Character> shifted = new ArrayList<>(set);
        shifted.sort((a, b) -> Integer.compare(cyclicShift(a), cyclicShift(b)));
        System.out.println("Порядок по возрастанию циклического сдвига: " + shifted);
    }

    // Метод для вычисления циклического сдвига влево на n разрядов
    public static int cyclicShift(char c) {
        int hash = Character.hashCode(c);
        int n = 3; // Число разрядов сдвига
        int bits = 32; // Размер целого числа в битах
        return (hash << n) | (hash >>> (bits - n));
    }
}
