package com.datvutech.javabasic2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai04 extends JFrame implements ActionListener {

    private JTextField inputField;
    private double firstNumber;
    private String operator;

    public Bai04() {
        setTitle("Swing Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 5)); // Sửa GridLayout thành 5x4 để thêm hàng nút
        add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/", "sqrt",
            "4", "5", "6", "*", "%",
            "1", "2", "3", "-", "1/x",
            "0", ".", "C", "+", "=",};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            inputField.setText(inputField.getText() + command);
        } else if (command.equals(".")) {
            if (!inputField.getText().contains(".")) {
                inputField.setText(inputField.getText() + ".");
            }
        } else if (command.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(inputField.getText());
            operator = command;
            inputField.setText("");
        } else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(inputField.getText());
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }

            inputField.setText(String.valueOf(result));
        } else if (command.equals("%")) {
            double value = Double.parseDouble(inputField.getText());
            double result = value / 100.0;
            inputField.setText(String.valueOf(result));
        } else if (command.equals("C")) {
            inputField.setText("");
        } else if (command.equals("1/x")) {
            double value = Double.parseDouble(inputField.getText());
            double result = 1.0 / value;
            inputField.setText(String.valueOf(result));
        } else if (command.equals("sqrt")) {
            double value = Double.parseDouble(inputField.getText());
            double result = Math.sqrt(value);
            inputField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        Bai04 calculator = new Bai04();
        calculator.setVisible(true);
    }
}
