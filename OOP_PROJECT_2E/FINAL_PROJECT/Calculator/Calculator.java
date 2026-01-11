import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener
{
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private Font myFont = new Font("Poppins", Font.BOLD, 22);
    private Color bgColor = new Color(245, 245, 245);
    private Color btnColor = new Color(230, 230, 250);
    private Color opColor = new Color(173, 216, 230);
    private Color equalColor = new Color(100, 149, 237);

    private String num1Str = "", num2Str = "";
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean isSecondNum = false;

    public Calculator()
    {
        setTitle("Modern Calculator");
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(bgColor);

        textField = new JTextField();
        textField.setBounds(40, 25, 300, 60);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFont(myFont);
            btn.setFocusPainted(false);
            btn.setBackground(opColor);
            btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].setBackground(btnColor);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        }

        equButton.setBackground(equalColor);
        equButton.setForeground(Color.WHITE);
        clrButton.setBackground(new Color(255, 182, 193));
        delButton.setBackground(new Color(255, 218, 185));

        panel = new JPanel();
        panel.setBounds(40, 100, 300, 350);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(bgColor);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);
        panel.add(delButton);
        panel.add(clrButton);

        add(textField);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));
            }
        }

        if (e.getSource() == addButton || e.getSource() == subButton ||
            e.getSource() == mulButton || e.getSource() == divButton) {

            num1Str = textField.getText();
            num1 = Double.parseDouble(num1Str);

            if (e.getSource() == addButton) operator = '+';
            if (e.getSource() == subButton) operator = '-';
            if (e.getSource() == mulButton) operator = '*';
            if (e.getSource() == divButton) operator = '/';

            textField.setText("");
            isSecondNum = true;
        }

        if (e.getSource() == equButton) {
            num2Str = textField.getText();
            num2 = Double.parseDouble(num2Str);

            boolean isIntOperation = !num1Str.contains(".") && !num2Str.contains(".");

            if (isIntOperation) {
                int a = Integer.parseInt(num1Str);
                int b = Integer.parseInt(num2Str);
                int intResult = 0;

                switch (operator) {
                    case '+': intResult = a + b; break;
                    case '-': intResult = a - b; break;
                    case '*': intResult = a * b; break;
                    case '/':
                        if (b != 0) intResult = a / b;
                        else { textField.setText("Error"); return; }
                        break;
                }
                textField.setText(String.valueOf(intResult));
                num1 = intResult;
            } else {
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 != 0) result = num1 / num2;
                        else { textField.setText("Error"); return; }
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void main(String[] args)
    {
        new Calculator();
    }
}
