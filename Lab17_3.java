import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Lab17_3 {
    public static void printHeader(String labName) {
        String cwd = System.getProperty("user.dir");
        String user = System.getProperty("user.name");

        // formatting the datetime as mm-dd-yy @ hh:mm
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter
                formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy @ HH:mm");

        System.out.println("Working Directory: " + cwd);
        System.out.println("Programmer: " + user);
        String labTime = String.format("%s: %s%n", labName,
                                       now.format(formatter));
        System.out.println(labTime);
    }

    public static void main(String[] args) {
        printHeader("Lab 17.3");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        double[] sales = IntStream.range(0, 5).mapToDouble(i -> {
            System.out.printf("Enter today's sales for store %d: ", i + 1);
            return sc.nextDouble();
        }).toArray();

        System.out.printf("%n%s, here is the SALES BAR CHART%n", name);
        for (double sale : sales) {
            int amount = (int) sale / 100;
            System.out.println(" ".repeat(8) + "*".repeat(amount));
        }

    }
}