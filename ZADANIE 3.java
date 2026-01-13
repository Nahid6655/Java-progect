import java.util.Scanner;

public class RootFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите начало интервала a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Введите конец интервала b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Введите точность epsilon: ");
        double epsilon = scanner.nextDouble();
        
        // Проверяем, что на концах интервала функция имеет разные знаки
        double fa = function(a);
        double fb = function(b);
        
        if (fa * fb > 0) {
            System.out.println("На указанном интервале нет корня или их несколько.");
            System.out.println("f(a) = " + fa + ", f(b) = " + fb);
            scanner.close();
            return;
        }
        
        // Метод бисекции (деления пополам)
        double root = bisectionMethod(a, b, epsilon);
        
        System.out.println("Найденный корень: " + root);
        System.out.println("Значение функции в корне: " + function(root));
        scanner.close();
    }
    
    private static double bisectionMethod(double a, double b, double epsilon) {
        double mid = 0;
        
        while (Math.abs(b - a) > epsilon) {
            mid = (a + b) / 2;
            double fmid = function(mid);
            
            if (function(a) * fmid < 0) {
                b = mid;
            } else {
                a = mid;
            }
        }
        
        return (a + b) / 2;
    }
    
    private static double function(double x) {
        return Math.pow(x, 3) + x + 1;
    }
}
