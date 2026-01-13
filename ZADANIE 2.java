import java.util.Scanner;

public class IntegralArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите начало отрезка a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Введите конец отрезка b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Введите количество разбиений n (чем больше, тем точнее): ");
        int n = scanner.nextInt();
        
        double area = 0.0;
        double step = (b - a) / n;
        
        // Метод прямоугольников (средних)
        for (int i = 0; i < n; i++) {
            double x = a + (i + 0.5) * step;
            double y = function(x);
            area += y * step;
        }
        
        System.out.println("Площадь под графиком: " + area);
        scanner.close();
    }
    
    private static double function(double x) {
        return Math.pow(x, 3) + x + 1;
    }
}
