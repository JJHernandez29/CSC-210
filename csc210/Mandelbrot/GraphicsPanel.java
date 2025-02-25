package Mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsPanel extends JPanel {
    private BufferedImage image;
    private int width;
    private int height;
    private double minReal;
    private double maxReal;
    private double minImaginary;
    private double maxImaginary;
    private int maxIterations;

    public GraphicsPanel() {
        this.width = 800; // Default size
        this.height = 800; // Default size
        this.minReal = -2.5;
        this.maxReal = 1.5;
        this.minImaginary = -2.0;
        this.maxImaginary = 2.0;
        this.maxIterations = 1000;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void setParameters(int width, int height, double minReal, double maxReal, double minImaginary, double maxImaginary) {
        this.width = width;
        this.height = height;
        this.minReal = minReal;
        this.maxReal = maxReal;
        this.minImaginary = minImaginary;
        this.maxImaginary = maxImaginary;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void generateMandelbrotSet() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double real = LinearInterpolation.map(x, 0, width, minReal, maxReal);
                double imaginary = LinearInterpolation.map(y, 0, height, minImaginary, maxImaginary);

                ComplexNumber c = new ComplexNumber(real, imaginary);
                int iterations = computeMandelbrot(c);

                int color = mapColor(iterations, maxIterations);
                image.setRGB(x, y, color);
            }
        }
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

    private int mapColor(int iterations, int maxIterations) {
        if (iterations == maxIterations) {
            return 0;
        }

        // Gradient colors
        int r = (iterations * 9) % 256;
        int g = (iterations * 5) % 256;
        int b = (iterations * 3) % 256;

        return (r << 16) | (g << 8) | b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
