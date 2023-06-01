package com.datvutech.javabasic2.bai06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bai06 extends JFrame {
    private ArrayList<Employee> employeeList;
    private JComboBox<String> departmentComboBox;
    private JList<Employee> employeeJList;
    private DefaultListModel<Employee> employeeListModel;
    private JTextField idTextField;
    private JTextField fullNameTextField;
    private JTextField joinedDateTextField;
    private JTextField birthdayTextField;

    public Bai06() {
        employeeList = new ArrayList<>();
        employeeListModel = new DefaultListModel<>();
        employeeJList = new JList<>(employeeListModel);
        idTextField = new JTextField(10);
        fullNameTextField = new JTextField(10);
        joinedDateTextField = new JTextField(10);
        birthdayTextField = new JTextField(10);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editEmployee();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Department: "));
        departmentComboBox = new JComboBox<>();
        departmentComboBox.addItem("All");
        departmentComboBox.addItem("Department 1");
        departmentComboBox.addItem("Department 2");
        departmentComboBox.addItem("Department 3");
        departmentComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                filterEmployeesByDepartment();
            }
        });
        topPanel.add(departmentComboBox);

        JPanel infoPanel = new JPanel(new GridLayout(4, 2));
        infoPanel.add(new JLabel("ID:"));
        infoPanel.add(idTextField);
        infoPanel.add(new JLabel("Full Name:"));
        infoPanel.add(fullNameTextField);
        infoPanel.add(new JLabel("Joined Date:"));
        infoPanel.add(joinedDateTextField);
        infoPanel.add(new JLabel("Birthday:"));
        infoPanel.add(birthdayTextField);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(employeeJList), BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        employeeJList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                displayEmployeeInfo();
            }
        });

        setTitle("Employee Management App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        add(mainPanel);
    }

    private void addEmployee() {
        String id = idTextField.getText();
        String fullName = fullNameTextField.getText();
        String joinedDate = joinedDateTextField.getText();
        String birthday = birthdayTextField.getText();
        String department = (String) departmentComboBox.getSelectedItem();

        Employee newEmployee = new Employee(id, fullName, joinedDate, birthday, department);
        employeeList.add(newEmployee);
        employeeListModel.addElement(newEmployee);
    }

    private void editEmployee() {
        Employee selectedEmployee = employeeJList.getSelectedValue();
        if (selectedEmployee == null) {
            JOptionPane.showMessageDialog(this, "No employee selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = idTextField.getText();
        String fullName = fullNameTextField.getText();
        String joinedDate = joinedDateTextField.getText();
        String birthday = birthdayTextField.getText();
        String department = (String) departmentComboBox.getSelectedItem();

        selectedEmployee.setId(id);
        selectedEmployee.setFullName(fullName);
        selectedEmployee.setJoinedDate(joinedDate);
        selectedEmployee.setBirthday(birthday);
        selectedEmployee.setDepartment(department);

        employeeJList.repaint();
    }

    private void deleteEmployee() {
        Employee selectedEmployee = employeeJList.getSelectedValue();
        if (selectedEmployee == null) {
            JOptionPane.showMessageDialog(this, "No employee selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        employeeList.remove(selectedEmployee);
        employeeListModel.removeElement(selectedEmployee);
    }

    private void filterEmployeesByDepartment() {
        String selectedDepartment = (String) departmentComboBox.getSelectedItem();
        employeeListModel.clear();

        if (selectedDepartment.equals("All")) {
            for (Employee employee : employeeList) {
                employeeListModel.addElement(employee);
            }
        } else {
            for (Employee employee : employeeList) {
                if (employee.getDepartment().equals(selectedDepartment)) {
                    employeeListModel.addElement(employee);
                }
            }
        }
    }

    private void displayEmployeeInfo() {
        Employee selectedEmployee = employeeJList.getSelectedValue();
        if (selectedEmployee != null) {
            idTextField.setText(selectedEmployee.getId());
            fullNameTextField.setText(selectedEmployee.getFullName());
            joinedDateTextField.setText(selectedEmployee.getJoinedDate());
            birthdayTextField.setText(selectedEmployee.getBirthday());
        } else {
            idTextField.setText("");
            fullNameTextField.setText("");
            joinedDateTextField.setText("");
            birthdayTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Bai06 app = new Bai06();
                app.setVisible(true);
            }
        });
    }
}


