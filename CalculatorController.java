package org.example.GUI;
import org.example.BusinessLogic.CalculatorModel;
import org.example.Model.*;

import java.awt.event.*;

public class CalculatorController implements ActionListener {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // register listeners
        view.add.addActionListener(this);
        view.subtract.addActionListener(this);
        view.multiply.addActionListener(this);
        view.division.addActionListener(this);
        view.derive.addActionListener(this);
        view.integrate.addActionListener(this);
        view.clear.addActionListener(this);
        view.exit.addActionListener(this);
    }

    private void resetForOperations() {
        view.label3.setText(" The resulted polynomial ");
        view.label4.setVisible(false);
        view.polynomial4.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = model.stringToPolynomial(view.polynomial1.getText());
        Polynomial p2 = model.stringToPolynomial(view.polynomial2.getText());
        Polynomial result;
        Object[] intResult=new Object[2];
        Polynomial division[];
        if (e.getSource() == view.add) {
            result = model.addPolynomials(p1, p2);
            view.polynomial3.setText(result.polynomialToString());
            resetForOperations();
        } else if (e.getSource() == view.subtract) {
            result = model.subtractPolynomials(p1, p2);
            view.polynomial3.setText(result.polynomialToString());
            resetForOperations();
        } else if (e.getSource() == view.multiply) {
            result = model.multiplyPolynomials(p1, p2);
            view.polynomial3.setText(result.polynomialToString());
            resetForOperations();
        } else if (e.getSource() == view.division) {
            division = model.dividePolynomials(p1, p2);
            view.polynomial3.setText(division[0].divisionPolynomialToString());
            view.label3.setText("       Quotient          ");
            view.polynomial4.setText(division[1].divisionPolynomialToString());
            view.label4.setText("       Remainder        ");
            view.label4.setVisible(true);
            view.polynomial4.setVisible(true);
        } else if (e.getSource() == view.derive) {
            result = model.derivePolynomial(p1);
            view.polynomial3.setText(result.polynomialToString());
            result = model.derivePolynomial(p2);
            view.polynomial4.setText(result.polynomialToString());
            view.label3.setText("     First derived        ");
            view.label4.setText("     Second derived      ");
            view.label4.setVisible(true);
            view.polynomial4.setVisible(true);
        } else if (e.getSource() == view.integrate) {
            result = model.integratePolynomial(p1);
            view.polynomial3.setText(result.integratedPolynomialToString());
            result = model.integratePolynomial(p2);
            view.polynomial4.setText(result.integratedPolynomialToString());
            view.label3.setText("   First integrated       ");
            view.label4.setText("   Second integrated     ");
            view.label4.setVisible(true);
            view.polynomial4.setVisible(true);
        } else if (e.getSource() == view.clear) {
            view.polynomial1.setText("");
            view.polynomial2.setText("");
            view.polynomial3.setText("");
            resetForOperations();
        } else if (e.getSource() == view.exit) {
            System.exit(0);
        }
    }
}