
public class Program {
    public static double f(double x) {
        return Math.sin(x);
    }

    public static double calcIntegralByRectangles(double a, double b, int N) {
        double h = (b - a) / N;
        double result = 0;
        for (double x = a; x <= b; x += h) {
            result = result + f(x) * h;
        }
        return result;
    }


                public static double calcIntegralBySimpson(double a, double b, int N) {
                               double h = (b - a) / N;
                               double result = 0.0;
                               double x_last = 0.0;
                               // формально правая граница x <= b - h,
                               // однако в силу накопленной машинной погрешности последний необходимы для учета x = x + (2 * h) > b - h
                               // поэтому необходимо условие ставить как x < b
                               for (double x = a + h; x < b/*x <= b - h*/; x = x + (2 * h)) {
                                               result = result + f(x - h) + 4 * f(x) + f(x + h);
                                               x_last = x;          
                               }
                               System.out.println("x_last = " + x_last + "; b - h = " + (b - h));
                               return result * h / 3.0;
                }      
    
    public static void main(String[] args) {
        // 2.0000000000064175
        System.out.println(calcIntegralByRectangles(0, Math.PI, 1000000));
        System.out.println(calcIntegralBySimpson(0, Math.PI, 1000));
    }
}