package org.example.Model;

import org.example.Model.Monomial;

import java.util.*;

public class Polynomial {
    //I store the polynomial in a TreeMap: the key is the exponent and the value is the coefficient
    private TreeMap<Integer, Double> polynomial;

    public Polynomial() {
        //using the Collections.reverseOrder() method, I assure that the monomials of the polynomials are in decreasing order
        polynomial = new TreeMap<>(Collections.reverseOrder());
    }

    public Polynomial(TreeMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }

    public TreeMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public void addMonomial(Monomial monomial) {
        if (monomial.getCoefficient() != 0) {
            polynomial.put(monomial.getExponent(), monomial.getCoefficient());
        }
    }

    public int getDegree() {
        if (polynomial.isEmpty()) {
            return -1; // org.example.Model.Polynomial is zero
        }
        return Collections.max(polynomial.keySet());
    }

    public double getCoefficient(int exponent) {
        return polynomial.getOrDefault(exponent, 0.0);
    }

    public String polynomialToString() {  //this method will display polynomials with Integer coefficients since we needed the Double type for integration operation only
        String S = "";
        Integer exponent;
        Double coefficient;
        boolean firstTerm = true;
        for (Map.Entry<Integer, Double> i : this.polynomial.entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            if (coefficient == 0) {
                continue;
            }
            if (!firstTerm) {
                if (coefficient > 0) {
                    S += "+";
                }
            } else {
                firstTerm = false;
            }
            if (exponent == 0) {
                S += coefficient.intValue();
            } else {
                if (coefficient == 1) {
                    S += "x";
                } else if (coefficient == -1) {
                    S += "-x";
                } else {
                    S += coefficient.intValue() + "x";
                }
                if (exponent != 1) {
                    S += "^" + exponent;
                }
            }
        }
        if (S.equals("")) {
            return "0";
        } else {
            return S;
        }
    }

    public String divisionPolynomialToString() {
        String S = "";
        Integer exponent;
        Double coefficient;
        boolean firstTerm = true;
        for (Map.Entry<Integer, Double> i : this.polynomial.entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            if (coefficient == 0) {
                continue;
            }
            if (!firstTerm) {
                if (coefficient > 0) {
                    S += "+";
                }
            } else {
                firstTerm = false;
            }
            if (exponent == 0) {
                S += coefficient;
            } else {
                if (coefficient == 1) {
                    S += "x";
                } else if (coefficient == -1) {
                    S += "-x";
                } else {
                    S += coefficient + "x";
                }
                if (exponent != 1) {
                    S += "^" + exponent;
                }
            }
        }
        if (S.equals("")) {
            return "0";
        } else {
            return S;
        }
    }

    public String integratedPolynomialToString() {   //this method will display polynomials with Double coefficients
        if (this.polynomial.isEmpty()) {
            return "0";
        }
        String S = "";
        Integer exponent;
        Double coefficient;
        boolean firstTerm = true;
        for (Map.Entry<Integer, Double> i : this.polynomial.entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            if (coefficient == 0) {
                continue;
            }
            if (!firstTerm) {
                if (coefficient > 0) {
                    S += "+";
                }
            } else {
                firstTerm = false;
            }
            if (exponent == 0) {
                S += coefficient;
            } else {
                if (coefficient == 1) {
                    S += "x";
                } else if (coefficient == -1) {
                    S += "-x";
                } else {
                    S += coefficient+ "x";
                }
                if (exponent != 1) {
                    S += "^" + exponent;
                }
            }
        }
        S += "+C";
        return S;
    }
}