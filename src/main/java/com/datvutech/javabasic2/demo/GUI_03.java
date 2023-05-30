package com.datvutech.javabasic2.demo;

public class GUI_03 extends javax.swing.JFrame {

    public GUI_03() {
        initComponents();
        this.setSize(260, 350);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI_03 Demo");
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 200, 250);

        // Event listeners for txtl
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtlFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtlFocusLost(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtlKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtlKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlKeyTyped(evt);
            }
        });

        pack();
    }

    private void txtlFocusGained(java.awt.event.FocusEvent evt) {
        jTextArea1.append("txtl gains user's focus\n");
    }

    private void txtlFocusLost(java.awt.event.FocusEvent evt) {
        jTextArea1.append("txtl is lost user's focus\n");
    }

    private void txtlKeyPressed(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        jTextArea1.append("txtl is focused, the key " + c + " is pressed\n");
    }

    private void txtlKeyReleased(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        jTextArea1.append("txtl is focused, the key " + c + " is released\n");
    }

    private void txtlKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        jTextArea1.append("txtl is focused, the key " + c + " is typed\n");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_03().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
