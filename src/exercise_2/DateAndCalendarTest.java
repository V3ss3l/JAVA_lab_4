package exercise_2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateAndCalendarTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод данных
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt() - 1; // Месяцы в Calendar начинаются с 0

            System.out.print("Введите число: ");
            int day = scanner.nextInt();

            System.out.print("Введите часы (0-23): ");
            int hour = scanner.nextInt();

            System.out.print("Введите минуты (0-59): ");
            int minute = scanner.nextInt();

            // Создание объекта Calendar
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day, hour, minute);

            // Получение объекта Date
            Date date = calendar.getTime();

            // Форматирование даты для вывода
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            // Вывод
            System.out.println("Объект Calendar:");
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1)); // Добавляем 1, чтобы получить привычный формат месяца
            System.out.println("Число: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));

            System.out.println("\nОбъект Date:");
            System.out.println("Дата: " + dateFormat.format(date));
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
