package LAYOUT;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverterLayout extends JFrame {

    private JTextField txtPHP;
    private JComboBox<String> cmbCurrency;
    private JLabel lblResult;

    public CurrencyConverterLayout() {
        setTitle("Currency Converter");
        setSize(500, 400); // Increased size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel bgPanel = new JPanel(new GridBagLayout());
        bgPanel.setBackground(new Color(204, 255, 204)); 
        GridBagConstraints gbc = createGBC();

        // Title
        JLabel lblTitle = createLabel("Currency Converter", new Font("Poppins", Font.BOLD, 28), new Color(0, 50, 100));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        bgPanel.add(lblTitle, gbc);

        // PHP Label
        JLabel lblPHP = createLabel("Enter Amount in PHP:", new Font("Segoe UI", Font.PLAIN, 17), new Color(30, 60, 90));
        gbc.gridy = 1; gbc.gridwidth = 1;
        bgPanel.add(lblPHP, gbc);

        // PHP Input
        txtPHP = new JTextField(12);
        txtPHP.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txtPHP.setHorizontalAlignment(JTextField.CENTER);
        txtPHP.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        bgPanel.add(txtPHP, gbc);

        // Currency ComboBox
        String[] currencies = {
            "USD - US Dollar",
            "AUD - Australian Dollar",
            "CAD - Canadian Dollar",
            "EURO - Euro",
            "RIYAL - Saudi Riyal"
        };
        cmbCurrency = new JComboBox<>(currencies);
        cmbCurrency.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        cmbCurrency.setBackground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        bgPanel.add(cmbCurrency, gbc);

        // Convert Button
        JButton btnConvert = createButton("Convert", new Color(100, 180, 255));
        gbc.gridy = 3; gbc.gridwidth = 1; gbc.gridx = 0;
        bgPanel.add(btnConvert, gbc);

        // Clear Button
        JButton btnClear = createButton("Clear", new Color(255, 180, 120));
        gbc.gridx = 1;
        bgPanel.add(btnClear, gbc);

        // Result Label
        lblResult = createLabel("Converted Amount: ", new Font("Segoe UI", Font.BOLD, 20), new Color(0, 100, 0));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        bgPanel.add(lblResult, gbc);

        add(bgPanel);
    }

    private GridBagConstraints createGBC() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.anchor = GridBagConstraints.CENTER;
        return gbc;
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        button.setOpaque(true);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverterLayout().setVisible(true));
    }
}
