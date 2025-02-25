package Mandelbrot;

import java.awt.image.BufferedImage;

public class Mandelbrot {
    private int width;
    private int height;
    private int maxIterations;
    private double minReal;
    private double maxReal;
    private double minImaginary;
    private double maxImaginary;

    public Mandelbrot(int width, int height, int maxIterations) {
        this.width = width;
        this.height = height;
        this.maxIterations = maxIterations;
        this.minReal = -2.5;
        this.maxReal = 1.5;
        this.minImaginary = -2.0;
        this.maxImaginary = 2.0;
    }

    public BufferedImage generateImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double real = LinearInterpolation.map(x, 0, width, minReal, maxReal);
                double imaginary = LinearInterpolation.map(y, 0, height, minImaginary, maxImaginary);
                ComplexNumber c = new ComplexNumber(real, imaginary);

                int iterations = computeMandelbrot(c);
                int color = iterations | (iterations << 8) | (iterations << 16); // Grayscale
                image.setRGB(x, y, color);
            }
        }

        return image;
    }

    private int computeMandelbrot(ComplexNumber c) {
        ComplexNumber z = new ComplexNumber(0, 0);
        int iterations = 0;

        while (z.magnitude() <= 2.0 && iterations < maxIterations) {
            z = z.multiply(z).add(c);
            iterations++;
        }

        return iterations;
    }
}

