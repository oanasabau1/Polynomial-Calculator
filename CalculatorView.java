package org.example.GUI;

import org.example.BusinessLogic.CalculatorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorView {
    CalculatorModel model;
    JFrame frame;
    JPanel panel, pan, pol1, pol2, pol3, pol4, pAdd, pSub, pMul, pDiv, pDeriv, pIntegr, pClear, pExit, buttonPanel1, buttonPanel2;
    JTextField polynomial1, polynomial2, polynomial3, polynomial4;
    JLabel title, label1, label2, label3, label4, addLabel, subLabel, mulLabel, divLabel, derivLabel, integrLabel, clearLabel, exitLabel;
    JButton add, subtract, multiply, division, derive, integrate, clear, exit;
    ActionEvent e;

    public CalculatorView(CalculatorModel model) {
        this.model=model;

        frame = new JFrame("org.example.Model.Polynomial Calculator");
        frame.setBounds(600, 100, 480, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(4, 1));

        title = new JLabel("org.example.Model.Polynomial Calculator", JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setBackground(new Color(250, 3, 116));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);

        //created a panel to introduce the polynomials and show the result
        pan = new JPanel(new GridLayout(4, 1));
        pan.setBackground(new Color(250, 3, 116));
        pol1 = new JPanel();
        pol1.setBackground(new Color(250, 3, 116));
        pol2 = new JPanel();
        pol2.setBackground(new Color(250, 3, 116));
        pol3 = new JPanel();
        pol3.setBackground(new Color(250, 3, 116));
        pol4 = new JPanel();
        pol4.setBackground(new Color(250, 3, 116));
        polynomial1 = new JTextField(25);
        polynomial2 = new JTextField(25);
        polynomial3 = new JTextField(25);
        polynomial4 = new JTextField(25);
        label1 = new JLabel(" The first polynomial    ");
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label2 = new JLabel(" The second polynomial  ");
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label3 = new JLabel(" The resulted polynomial ");
        label3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        //the fourth field and label is used for the division, derivation and integration because we need to store 2 results, so I set its visibility on false
        label4 = new JLabel("");
        label4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label4.setVisible(false);
        polynomial4.setVisible(false);
        pol1.add(label1);
        pol1.add(polynomial1);
        pol2.add(label2);
        pol2.add(polynomial2);
        pol3.add(label3);
        pol3.add(polynomial3);
        pol4.add(label4);
        pol4.add(polynomial4);
        pan.add(pol1);
        pan.add(pol2);
        pan.add(pol3);
        pan.add(pol4);

        //created and designed the buttons for the operations
        add = new JButton("+");
        add.setPreferredSize(new Dimension(50, 50));
        add.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        subtract = new JButton("-");
        subtract.setPreferredSize(new Dimension(50, 50));
        subtract.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        multiply = new JButton("*");
        multiply.setPreferredSize(new Dimension(50, 50));
        multiply.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        division = new JButton("÷");
        division.setPreferredSize(new Dimension(50, 50));
        division.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        derive = new JButton("'");
        derive.setPreferredSize(new Dimension(50, 50));
        derive.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        integrate = new JButton("∫");
        integrate.setPreferredSize(new Dimension(50, 50));
        integrate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        clear = new JButton("C");
        clear.setPreferredSize(new Dimension(50, 50));
        clear.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        exit = new JButton("X");
        exit.setPreferredSize(new Dimension(50, 50));
        exit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        //adding the buttons in the panels
        pAdd = new JPanel(new GridLayout(2, 1));
        pAdd.add(add);
        addLabel = new JLabel("Add", JLabel.CENTER);
        addLabel.setBackground(new Color(250, 3, 116));
        addLabel.setOpaque(true);
        addLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pAdd.add(addLabel);
        pSub = new JPanel(new GridLayout(2, 1));
        pSub.add(subtract);
        subLabel = new JLabel("Sub", JLabel.CENTER);
        subLabel.setBackground(new Color(250, 3, 116));
        subLabel.setOpaque(true);
        subLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pSub.add(subLabel);
        pMul = new JPanel(new GridLayout(2, 1));
        pMul.add(multiply);
        mulLabel = new JLabel("Mul", JLabel.CENTER);
        mulLabel.setBackground(new Color(250, 3, 116));
        mulLabel.setOpaque(true);
        mulLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pMul.add(mulLabel);
        pDiv = new JPanel(new GridLayout(2, 1));
        pDiv.add(division);
        divLabel = new JLabel("Div", JLabel.CENTER);
        divLabel.setBackground(new Color(250, 3, 116));
        divLabel.setOpaque(true);
        divLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pDiv.add(divLabel);
        pDeriv = new JPanel(new GridLayout(2, 1));
        pDeriv.add(derive);
        derivLabel = new JLabel("Deriv", JLabel.CENTER);
        derivLabel.setBackground(new Color(250, 3, 116));
        derivLabel.setOpaque(true);
        derivLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pDeriv.add(derivLabel);
        pIntegr = new JPanel(new GridLayout(2, 1));
        pIntegr.add(integrate);
        integrLabel = new JLabel("Integr", JLabel.CENTER);
        integrLabel.setBackground(new Color(250, 3, 116));
        integrLabel.setOpaque(true);
        integrLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pIntegr.add(integrLabel);
        pClear = new JPanel(new GridLayout(2, 1));
        pClear.add(clear);
        clearLabel = new JLabel("Clear", JLabel.CENTER);
        clearLabel.setBackground(new Color(250, 3, 116));
        clearLabel.setOpaque(true);
        clearLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pClear.add(clearLabel);
        pExit = new JPanel(new GridLayout(2, 1));
        pExit.add(exit);
        exitLabel = new JLabel("Exit", JLabel.CENTER);
        exitLabel.setBackground(new Color(250, 3, 116));
        exitLabel.setOpaque(true);
        exitLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pExit.add(exitLabel);

        buttonPanel1 = new JPanel();
        buttonPanel2 = new JPanel();
        buttonPanel1.setBackground(new Color(250, 3, 116));
        buttonPanel2.setBackground(new Color(250, 3, 116));
        buttonPanel1.add(pAdd);
        buttonPanel1.add(pSub);
        buttonPanel1.add(pMul);
        buttonPanel1.add(pDiv);
        buttonPanel2.add(pDeriv);
        buttonPanel2.add(pIntegr);
        buttonPanel2.add(pClear);
        buttonPanel2.add(pExit);

        //adding the panels in the main frame
        panel.add(title);  //the label for title
        panel.add(pan);  //the panel with the text fields and labels for polynomials
        panel.add(buttonPanel1); //the first row of buttons
        panel.add(buttonPanel2); //the second row of buttons
        frame.add(panel);
        frame.setVisible(true);
    }
}