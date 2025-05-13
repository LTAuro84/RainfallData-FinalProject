public class Rainfall {
    private double[][] rainfallData; //stores rainfall amount
                                    //for each month across three years
    private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public Rainfall() {
        rainfallData = new double[][] {
            {4.96, 3.27, 1.5, 1.38, 2.28, 2.11, 1.61, 5.93, 4.3, 1.77, 8.72, 3.47},  // 2020
            {1.6, 3.88, 2.22, 10.02, 7.16, 2.74, 5.1, 5.14, 4.91, 6.39, 17.65, 4.3},  // 2021
            {1.81, 1.7, 6.04, 6.25, 4.53, 3.93, 6.66, 7.68, 15.79, 6.61, 10.16, 3.33} // 2022
        };
    }

    //calculates the totral rainfall for each year
    public double[] totalRainfallPerYear() {
        double[] totalRainfall = new double[3]; // 3 since we have 3 years
                                                // 0 -> 2020, 1 -> 2021, 2 -> 2022

        for (int i = 0; i < rainfallData.length; i++) { //iterates over years
            for (double rainfall : rainfallData[i]) {
                totalRainfall[i] += rainfall; //for each month it iterates, it adds the rainfall to the year's total.
            }
        }
        return totalRainfall;

        //example:
            // totalRainfall[0] = 4.96 + 3.27 + 1.5......
            
    }

    public double averageRainfallPerMonth() {
        double total = 0;
        for (double[] year : rainfallData) {
            for (double rainfall : year) {
                total += rainfall;
            }
        }
        return total / (rainfallData.length * 12);
    }

    public double specificYear(int year) {
        if (year < 2020 || year > 2022) {
            return -1;
        }
        return totalRainfallPerYear()[year - 2020];
    }

    //finds the year with the most rainfall
    public int yearWithMostRain() {
        double[] totalRainfall = totalRainfallPerYear();
        int maxIndex = 0;
        for (int i = 1; i < totalRainfall.length; i++) {
            if (totalRainfall[i] > totalRainfall[maxIndex]) {
                maxIndex = i;
            }
        }
        return 2020 + maxIndex;
    }

    //finds the year with the last rainfall
     public int yearWithLeastRain() {
        double[] totalRainfall = totalRainfallPerYear();
        int minIndex = 0;
        for (int i = 1; i < totalRainfall.length; i++) {
            if (totalRainfall[i] < totalRainfall[minIndex]) {
                minIndex = i;
            }
        }
        return 2020 + minIndex;
    }

    //finds the month with most rain in a specific year
    public String[] monthWithMostRaininYear(int year) {
        if (year < 2022 || year > 2022) {
            return new String[]{"Invalid year", "0"};
        }

        int yearIndex = year - 2020; //calculates the index of the year
        int maxMonth = 0; //keeps track of the month with maximum rainfall
                          //first month would be january [i = 0]

        for (int i = 1; i < 12; i++) { //starts a loop to compare rainfall for all 12 months [1 through 11]

            if(rainfallData[yearIndex][i] > rainfallData[yearIndex][maxMonth]) { //compares rainfall of the current month[i] with the current maximum month
                maxMonth = i;
            }
        }

        return new String[]{monthNames[maxMonth], String.valueOf(rainfallData[yearIndex][maxMonth])}; 
    }

    public String[] monthWithLeastRaininYear(int year) {
        if (year < 2022 || year > 2022) {
            return new String[]{"Invalid year", "0"};
        }

        int yearIndex = year - 2020; //calculates the index of the year
        int maxMonth = 0; //keeps track of the month with maximum rainfall
                          //first month would be january [i = 0]

        for (int i = 1; i < 12; i++) { //starts a loop to compare rainfall for all 12 months [1 through 11]

            if(rainfallData[yearIndex][i] < rainfallData[yearIndex][maxMonth]) { //compares rainfall of the current month[i] with the current maximum month
                maxMonth = i;
            }
        }

        return new String[]{monthNames[maxMonth], String.valueOf(rainfallData[yearIndex][maxMonth])}; 
    }
}