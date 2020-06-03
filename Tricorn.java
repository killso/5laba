import java.awt.geom.Rectangle2D;
class Tricorn extends FractalGenerator {
    public String toString() { //возвращаем имя
        return "Tricorn";
    }
    public static final int MAX_ITERATIONS = 2000;
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2; //поменяли
        range.width = 4; //поменяли
        range.height = 4; //поменяли
        return;
    }
    public int numIterations(double x, double y) {
        int k = 0;
        double a1 = 0;
        double a2 = 0;
        double kvdrt = (a1 * a1) + (a2 * a2);
        while (k < MAX_ITERATIONS && kvdrt < 4) {
            double a3 = (a1 * a1) - (a1 * a1) + x;
            double a4 = (2 * a1 * a2) + y;
            a1 = a3;
            a2 = a4;
            kvdrt = (a1 * a1) + (a2 * a2);
            k++;
        }
        if (k == MAX_ITERATIONS) return -1; //точка не выходит за границы
        return k; //кол-во итераций
    }
}