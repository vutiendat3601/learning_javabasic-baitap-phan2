package com.datvutech.javabasic2.demo;

import javax.swing.JOptionPane;

public class GUI_02 extends javax.swing.JFrame {

    public GUI_02() {
        initComponents();
        this.setSize(300, 300);
    }

    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI_02 Demo");
        getContentPane().setLayout(null);

        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane1.setViewportView(txt1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 234, 230);

        // Set the text area as editable
        txt1.setEditable(true);

        pack();
        
        // Add event listeners
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        txt1.append("The window is activated\n");
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        txt1.append("The window is closed\n");
        JOptionPane.showMessageDialog(this, "The window is closed!");
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        txt1.append("The window is closing\n");
        JOptionPane.showMessageDialog(this, "The window is closing!");
    }

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {
        txt1.append("The window is deactivated\n");
    }

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {
        txt1.append("The window is de-iconified\n");
    }

    private void formWindowIconified(java.awt.event.WindowEvent evt) {
        txt1.append("The window is iconified\n");
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        txt1.append("The window is opened\n");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GUI_02().setVisible(true);
        });
    }

    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt1;
}
