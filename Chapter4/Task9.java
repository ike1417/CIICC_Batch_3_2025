package Chapter4;
import static java.lang.Math.*;
public class Task9 {

    public static int add(int a, int b) {
        return addExact(a, b);
    }
    
    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }


    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

        public static int divide(int a, int b) {
        return floorDiv(a, b); 
    }

    public static void main(String[] args) {        
        int a = 20, b = 4;
        int x = 15, y = 7;
      
        System.out.println("Addition of " + a + " and " + b + " = " + add(a, b));
        System.out.println("Subtraction of " + x + " and " + y + " = " + subtract(x, y));
        System.out.println("Multiplication of " + b + " and " + y + " = " + multiply(b, y));
        System.out.println("Division of " + x + " by " + b + " = " + divide(x, b));
    }
}
