package example2;
/**
 * Quadratic
 * 
 * Compute and print real or imaginary roots of a quadratic equation.
 * 
 * Reference: http://www.1728.org/quadratc.htm
 */
public class Quadratic {
    
    void printRoots(double a, double b, double c) {
        
        double d = b * b - 4 * a * c;
        
        if (d < 0) {
            double x = -b/(2*a); // real part of the solution
            double xi = Math.sqrt(-d)/(2*a); // imaginary part
            
            System.out.printf("%.2f + %.2fi and %.2f - %.2fi are imaginary roots of %.2fx^2 + %.2fx + %.2f\n\n",
                              x, xi, x, xi, a, b, c);
        } else {
            double x1 = (-b + Math.sqrt(d))/ (2 * a);
            double x2 = (-b - Math.sqrt(d))/ (2 * a);
            
            System.out.printf("%.2f and %.2f are real roots of %.2fx^2 + %.2fx + %.2f\n\n",
                              x1, x2, a, b, c);
        }
        
    }
    
    public static void main(String[] args) {
        
        Quadratic q = new Quadratic();
        
        q.printRoots(3, 4, 5);
        q.printRoots(2, 4, -30);
        q.printRoots(12, 5, 3);
    }
}
