import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rainfall rainfall = new Rainfall();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Total rainfall inches for each year");
            System.out.println("2. The average rainfall inches per month for years 2020 - 2022");
            System.out.println("3. The total rainfall inches per specific year determined by the user");
            System.out.println("4. The year with the most rain");
            System.out.println("5. The year with the least rain");
            System.out.println("6. The month with the most rain in a specific year determined by the user (month and rainfall inches amount).");
            System.out.println("7. The month with the least rain in a specific year determined by the user (month and rainfall inches)");
            System.out.println("8. Exit");
            System.out.println("Enter your choice");

            int choice = input.nextInt();

            switch (choice) {
                
                case 1:
                    double[] yearlyTotal = rainfall.totalRainfallPerYear();
                    System.out.println("Total rainfall inches for each year: ");
                    for (int i = 0; i < yearlyTotal.length; i++) {
                       System.out.printf("Year %d: %.2f inches\n", 2020 + i, yearlyTotal[i]);
                    }
                break;

                case 2:
                    double average = rainfall.averageRainfallPerMonth();
                    System.out.printf("\nAverage monthly rainfall per year: %.2f inches\n", average);
                break;

                case 3:
                    System.out.println("Enter year (2020-2022): ");
                    int year = input.nextInt();
                    double total = rainfall.specificYear(year);
                    if (total == -1) {
                        System.out.println("Invalid year entered");
                    } else {
                        System.out.printf("Total rainfall for %d: %.2f inches\n", year, total);
                    }
                break;

                case 4:
                    int mostRain = rainfall.yearWithMostRain();
                    System.out.printf("\nYear with most rain: %d\n", mostRain);
                break;
                
                case 5: 
                    int lessRain = rainfall.yearWithLeastRain();
                    System.out.printf("\nYear with least rain: %d\n", lessRain);
                break;

                case 6: 
                    System.out.println("Enter year to find the wettest month (2020-2022): ");
                    year = input.nextInt();
                    String[] maxMonth = rainfall.monthWithMostRaininYear(year);
                    if (maxMonth[0].equals("Invalid year")) {
                        System.out.println("Invalid year entered");
                    } else {
                        System.out.printf("Wettest month in %d: %s with %s inches\n", 
                                        year, maxMonth[0], maxMonth[1]);
                    }
                break;

                case 7: 
                    System.out.println("Enter year to find the wettest month (2020-2022): ");
                    year = input.nextInt();
                    String[] minMonth = rainfall.monthWithLeastRaininYear(year);
                    if (minMonth[0].equals("Invalid year")) {
                        System.out.println("Invalid year entered");
                    } else {
                        System.out.printf("Wettest month in %d: %s with %s inches\n", 
                                        year, minMonth[0], minMonth[1]);
                     }       
                break;

                case 8:
                     input.close();
                     return;
            }


        }
    }
}
