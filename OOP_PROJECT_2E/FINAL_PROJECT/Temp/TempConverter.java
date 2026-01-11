import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TempConverter extends JFrame 
{

    private JTextField txtTemp;
    private JTextArea txtDisplayResult;
    private JRadioButton rdCelcius, rdFarenheit, rdKelvin;
    private JButton btnClear;

    public TempConverter() 
    {
        initComponents();
    }

    private void initComponents() 
    {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 295);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(0xFFFFCC));

        JLabel lblTemp = new JLabel("Enter temperature value:");
        lblTemp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTemp.setBounds(5, 20, 160, 22);
        add(lblTemp);

        txtTemp = new JTextField();
        txtTemp.setBounds(165, 20, 245, 30);
        add(txtTemp);

        // Panel for radio buttons
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(0xFFFFCC));
        panel1.setLayout(null);
        panel1.setBounds(85, 65, 275, 35);
        add(panel1);

        rdCelcius = new JRadioButton("Celsius");
        rdCelcius.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rdCelcius.setBounds(0, 5, 80, 25);
        panel1.add(rdCelcius);

        rdFarenheit = new JRadioButton("Fahrenheit");
        rdFarenheit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rdFarenheit.setBounds(90, 5, 100, 25);
        panel1.add(rdFarenheit);

        rdKelvin = new JRadioButton("Kelvin");
        rdKelvin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rdKelvin.setBounds(190, 5, 95, 25);
        panel1.add(rdKelvin);

        ButtonGroup group = new ButtonGroup();
        group.add(rdCelcius);
        group.add(rdFarenheit);
        group.add(rdKelvin);

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(25, 110, 395, 95);
        add(scrollPane1);

        txtDisplayResult = new JTextArea();
        txtDisplayResult.setEditable(false);
        scrollPane1.setViewportView(txtDisplayResult);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnClear.setBounds(175, 215, 100, 30);
        add(btnClear);

        // Event listeners
        rdCelcius.addActionListener(e -> convertToCelsius());
        rdFarenheit.addActionListener(e -> convertToFahrenheit());
        rdKelvin.addActionListener(e -> convertToKelvin());
        btnClear.addActionListener(e -> clearAll());
    }

    private void convertToCelsius() {
        try {
            double temp = Double.parseDouble(txtTemp.getText());
            double cToF = (temp * 9 / 5) + 32;
            double cToK = temp + 273.15;
            txtDisplayResult.setText(String.format("%.2f °C = %.2f °F\n%.2f °C = %.2f K", temp, cToF, temp, cToK));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void convertToFahrenheit() {
        try {
            double temp = Double.parseDouble(txtTemp.getText());
            double fToC = (temp - 32) * 5 / 9;
            double fToK = (temp - 32) * 5 / 9 + 273.15;
            txtDisplayResult.setText(String.format("%.2f °F = %.2f °C\n%.2f °F = %.2f K", temp, fToC, temp, fToK));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void convertToKelvin() {
        try {
            double temp = Double.parseDouble(txtTemp.getText());
            double kToC = temp - 273.15;
            double kToF = (temp - 273.15) * 9 / 5 + 32;
            txtDisplayResult.setText(String.format("%.2f K = %.2f °C\n%.2f K = %.2f °F", temp, kToC, temp, kToF));
        } catch (NumberFormatException ex) {
            txtDisplayResult.setText("Invalid input. Please enter a numeric value.");
        }
    }

    private void clearAll() {
        txtTemp.setText("");
        txtDisplayResult.setText("");
        rdCelcius.setSelected(false);
        rdFarenheit.setSelected(false);
        rdKelvin.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TempConverter().setVisible(true);
        });
    }
}
