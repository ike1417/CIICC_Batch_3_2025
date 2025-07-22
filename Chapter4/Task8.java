package Chapter4;

public class Task8 {
    
    public static int sumCumulative(int... numbers) {
        int totalSum = 0;

        for (int num : numbers) {
            int cumSum = (num * (num + 1)) / 2; 
            System.out.println("Cumulative sum of " + num + " = " + cumSum);
            totalSum += cumSum;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        
        int total = sumCumulative(4, 5, 10);

        System.out.println("Total sum of cumulative values: " + total);
    }
}
