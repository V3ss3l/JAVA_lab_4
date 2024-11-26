package exercise_1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s %s', birthDate=%s}",
                firstName,
                lastName,
                formatBirthDate("medium"));
    }

    // Метод для получения строки с датой рождения в заданном формате
    public String formatBirthDate(String formatType) {
        DateFormat dateFormat;

        switch (formatType.toLowerCase()) {
            case "short":
                dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                break;
            case "medium":
                dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
                break;
            case "long":
                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
                break;
            case "full":
                dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
                break;
            default:
                throw new IllegalArgumentException("Invalid format type. Use 'short', 'medium', 'long', or 'full'.");
        }

        return dateFormat.format(birthDate);
    }

    public static void main(String[] args) {
        try {
            // Пример даты рождения
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = sdf.parse("1995-07-25");

            // Создание объекта Person
            Person person = new Person("Иван", "Иванов", birthDate);

            // Вывод информации о человеке
            System.out.println(person); // toString()

            // Форматы даты
            System.out.println("Short format: " + person.formatBirthDate("short"));
            System.out.println("Medium format: " + person.formatBirthDate("medium"));
            System.out.println("Long format: " + person.formatBirthDate("long"));
            System.out.println("Full format: " + person.formatBirthDate("full"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}