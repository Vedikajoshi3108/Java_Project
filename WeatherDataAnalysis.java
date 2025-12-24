import java.util.Scanner;

public class WeatherDataAnalysis {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store temperatures for 30 days
        double[] temperatures = new double[30];
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
        System.out.println("=== WEATHER DATA ANALYSIS SYSTEM ===\n");
        
        // Input temperatures
        System.out.println("Enter daily temperatures (in Celsius) for 30 days:");
        for (int i = 0; i < 30; i++) {
            System.out.print("Day " + (i + 1) + " (" + days[i % 7] + "): ");
            temperatures[i] = sc.nextDouble();
        }
        
        // Menu-driven system
        while (true) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Display All Temperatures");
            System.out.println("2. Calculate Average Temperature");
            System.out.println("3. Find Hottest Day");
            System.out.println("4. Find Coldest Day");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    displayTemperatures(temperatures, days);
                    break;
                case 2:
                    calculateAverage(temperatures);
                    break;
                case 3:
                    findHottestDay(temperatures);
                    break;
                case 4:
                    findColdestDay(temperatures);
                    break;
                case 0:
                    System.out.println("\nThank you for using Weather Analysis System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    // Display all temperatures
    public static void displayTemperatures(double[] temps, String[] days) {
        System.out.println("\n--- All Temperature Records ---");
        for (int i = 0; i < temps.length; i++) {
            System.out.printf("Day %2d (%s): %.1f°C\n", (i + 1), days[i % 7], temps[i]);
        }
    }
    
    // Calculate average temperature
    public static void calculateAverage(double[] temps) {
        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }
        double avg = sum / temps.length;
        System.out.printf("\n--- Average Temperature ---\n");
        System.out.printf("Average: %.2f°C\n", avg);
    }
    
    // Find hottest day
    public static void findHottestDay(double[] temps) {
        double max = temps[0];
        int maxDay = 0;
        
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > max) {
                max = temps[i];
                maxDay = i;
            }
        }
        
        System.out.println("\n--- Hottest Day ---");
        System.out.printf("Day %d with %.1f°C\n", (maxDay + 1), max);
    }
    
    // Find coldest day
    public static void findColdestDay(double[] temps) {
        double min = temps[0];
        int minDay = 0;
        
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                minDay = i;
            }
        }
        
        System.out.println("\n--- Coldest Day ---");
        System.out.printf("Day %d with %.1f°C\n", (minDay + 1), min);
    }
}

