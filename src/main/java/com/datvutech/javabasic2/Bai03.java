package com.datvutech.javabasic2;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai03 extends JFrame {
    private JTextField numField1, numField2, resultField;
    private JRadioButton addButton, subtractButton, multiplyButton, divideButton;
    private JButton resolveButton, deleteButton, exitButton;

    public Bai03() {
        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text fields
        numField1 = new JTextField(10);
        numField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        // Create radio buttons
        addButton = new JRadioButton("+");
        subtractButton = new JRadioButton("-");
        multiplyButton = new JRadioButton("*");
        divideButton = new JRadioButton("/");

        // Create button group for radio buttons
        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(addButton);
        operationGroup.add(subtractButton);
        operationGroup.add(multiplyButton);
        operationGroup.add(divideButton);

        // Create resolve button
        resolveButton = new JButton("Resolve");
        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation();
            }
        });

        // Create delete button
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numField1.setText("");
                numField2.setText("");
                resultField.setText("");
            }
        });

        // Create exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create panel for buttons on the left
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(resolveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        // Create panel for input fields and radio buttons on the right
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 4));
        radioPanel.add(addButton);
        radioPanel.add(subtractButton);
        radioPanel.add(multiplyButton);
        radioPanel.add(divideButton);
        inputPanel.add(numField1);
        inputPanel.add(numField2);
        inputPanel.add(radioPanel);

        // Add components to the frame
        add(buttonPanel, BorderLayout.WEST);
        add(inputPanel, BorderLayout.CENTER);
        add(resultField, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void performOperation() {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result;
            char operator = ' ';

            if (addButton.isSelected()) {
                operator = '+';
                result = num1 + num2;
            } else if (subtractButton.isSelected()) {
                operator = '-';
                result = num1 - num2;
            } else if (multiplyButton.isSelected()) {
                operator = '*';
                result = num1 * num2;
            } else if (divideButton.isSelected()) {
                operator = '/';
                result = num1 / num2;
            } else {
                throw new IllegalArgumentException("No operation selected");
            }

            resultField.setText(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "No operation selected. Please select an operation.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bai03();
            }
        });
    }
}
