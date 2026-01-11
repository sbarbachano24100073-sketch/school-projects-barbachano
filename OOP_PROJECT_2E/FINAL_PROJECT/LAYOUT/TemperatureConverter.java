package LAYOUT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends JFrame 
{

    private JTextField txtTemp;
    private JTextArea txtDisplayResult;
    private JRadioButton rdCelsius, rdFahrenheit, rdKelvin;
    private JButton btnClear;

    public TemperatureConverter() 
    {
        initComponents();
    }

    private void initComponents() 
    {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0xFFFFCC));

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel lblTemp = new JLabel("Enter temperature value:");
        lblTemp.setFont(font);

        txtTemp = new JTextField();
        txtTemp.setFont(font);
        txtTemp.setToolTipText("Enter a numeric temperature value");

        rdCelsius = new JRadioButton("Celsius");
        rdFahrenheit = new JRadioButton("Fahrenheit");
        rdKelvin = new JRadioButton("Kelvin");

        rdCelsius.setFont(font);
        rdFahrenheit.setFont(font);
        rdKelvin.setFont(font);

        ButtonGroup group = new ButtonGroup();
        group.add(rdCelsius);
        group.add(rdFahrenheit);
        group.add(rdKelvin);

        txtDisplayResult = new JTextArea(4, 30);
        txtDisplayResult.setFont(font);
        txtDisplayResult.setEditable(false);
        txtDisplayResult.setLineWrap(true);
        txtDisplayResult.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtDisplayResult);

        btnClear = new JButton("Clear");
        btnClear.setFont(font);

        // Layout
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xFFFFCC));
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTemp)
                .addComponent(txtTemp))
            .addGroup(layout.createSequentialGroup()
                .addComponent(rdCelsius)
                .addComponent(rdFahrenheit)
                .addComponent(rdKelvin))
            .addComponent(scrollPane)
            .addComponent(btnClear, GroupLayout.Alignment.CENTER)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTemp)
                .addComponent(txtTemp))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(rdCelsius)
                .addComponent(rdFahrenheit)
                .addComponent(rdKelvin))
            .addComponent(scrollPane)
            .addComponent(btnClear)
        );

        add(panel);

        // Event listeners
        rdCelsius.addActionListener(e -> convertToCelsius());
        rdFahrenheit.addActionListener(e -> convertToFahrenheit());
        rdKelvin.addActionListener(e -> convertToKelvin());
        btnClear.addActionListener(e -> clearAll());
    }

    private void convertToCelsius() {
        String input = txtTemp.getText().trim();
        if (input.isEmpty()) {
            txtDisplayResult.setText("Please enter a temperature value.");
            return;
        }
        try {
            double temp = Double.parseDouble(input);
            double cToF = (temp * 9 / 5) + 32;
            double cToK = temp + 273.15;
            txtDisplayResult.setText(String.format("%.2f °C = %.2f °F\n%.2f °C = %.2f K", temp, cToF, temp, cToK));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void convertToFahrenheit() {
        String input = txtTemp.getText().trim();
        if (input.isEmpty()) {
            txtDisplayResult.setText("Please enter a temperature value.");
            return;
        }
        try {
            double temp = Double.parseDouble(input);
            double fToC = (temp - 32) * 5 / 9;
            double fToK = fToC + 273.15;
            txtDisplayResult.setText(String.format("%.2f °F = %.2f °C\n%.2f °F = %.2f K", temp, fToC, temp, fToK));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void convertToKelvin() {
        String input = txtTemp.getText().trim();
        if (input.isEmpty()) {
            txtDisplayResult.setText("Please enter a temperature value.");
            return;
        }
        try {
            double temp = Double.parseDouble(input);
            double kToC = temp - 273.15;
            double kToF = kToC * 9 / 5 + 32;
            txtDisplayResult.setText(String.format("%.2f K = %.2f °C\n%.2f K = %.2f °F", temp, kToC, temp, kToF));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void clearAll() {
        txtTemp.setText("");
        txtDisplayResult.setText("");
        rdCelsius.setSelected(false);
        rdFahrenheit.setSelected(false);
        rdKelvin.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter().setVisible(true));
    }
}
