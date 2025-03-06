import java.util.Scanner;

public class DisplayCalendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the month (MM): ");
            int month = sc.nextInt();
            System.out.print("Enter the year (YYYY): ");
            int year = sc.nextInt();

            // Display the calendar
            displayCalendar(month, year);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to get the name of the month
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    // Method to get the number of days in the month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    // Method to get the first day of the month using the Gregorian calendar algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (1 + x + (31 * m) / 12) % 7;
        return d;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDayOfMonth = getFirstDayOfMonth(month, year);

        System.out.println("     " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d ", i);
            if ((i + firstDayOfMonth) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

/*
Example Input:
Enter the month (MM): 07
Enter the year (YYYY): 2005

Example Output:
     July 2005
Sun Mon Tue Wed Thu Fri Sat
                   1   2 
 3   4   5   6   7   8   9 
10  11  12  13  14  15  16 
17  18  19  20  21  22  23 
24  25  26  27  28  29  30 
31
*/

