package Mandelbrot;

import javax.swing.*;
import java.awt.*;

public class MandelbrotGUI extends JFrame {
    private GraphicsPanel graphicsPanel;
    private JTextField minRealField;
    private JTextField maxRealField;
    private JTextField minImaginaryField;
    private JTextField maxImaginaryField;
    private JTextField widthField;
    private JTextField heightField;
    private JButton computeButton;

    public MandelbrotGUI() {
        setTitle("Mandelbrot.Mandelbrot Viewer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        graphicsPanel = new GraphicsPanel();
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Mandelbrot.Mandelbrot Display"));
        displayPanel.add(graphicsPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 4));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Settings"));

        minRealField = new JTextField("-2.5");
        maxRealField = new JTextField("1.5");
        minImaginaryField = new JTextField("-2.0");
        maxImaginaryField = new JTextField("2.0");
        widthField = new JTextField("800");
        heightField = new JTextField("800");

        inputPanel.add(new JLabel("Min Real:"));
        inputPanel.add(minRealField);
        inputPanel.add(new JLabel("Max Real:"));
        inputPanel.add(maxRealField);
        inputPanel.add(new JLabel("Min Imaginary:"));
        inputPanel.add(minImaginaryField);
        inputPanel.add(new JLabel("Max Imaginary:"));
        inputPanel.add(maxImaginaryField);
        inputPanel.add(new JLabel("Width:"));
        inputPanel.add(widthField);
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(heightField);

        computeButton = new JButton("Compute");
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(computeButton);


        add(displayPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);


        computeButton.addActionListener(e -> {
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            double minReal = Double.parseDouble(minRealField.getText());
            double maxReal = Double.parseDouble(maxRealField.getText());
            double minImaginary = Double.parseDouble(minImaginaryField.getText());
            double maxImaginary = Double.parseDouble(maxImaginaryField.getText());

            graphicsPanel.setParameters(width, height, minReal, maxReal, minImaginary, maxImaginary);
            graphicsPanel.generateMandelbrotSet();
            graphicsPanel.repaint();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MandelbrotGUI gui = new MandelbrotGUI();
            gui.setVisible(true);
        });
    }
}
