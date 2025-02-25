package Mandelbrot;

public class LinearInterpolation {
    public static double map(double value, double sourceMin, double sourceMax, double targetMin, double targetMax) {
        return targetMin + ((value - sourceMin) / (sourceMax - sourceMin)) * (targetMax - targetMin);
    }
}
