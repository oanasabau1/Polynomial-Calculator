package org.example.BusinessLogic;
import org.example.Model.Monomial;
import org.example.Model.Polynomial;

import javax.swing.*;
import java.util.*;
import java.util.regex.*;

public class CalculatorModel {
    public static Polynomial stringToPolynomial(String polynomialInput) {
        Polynomial polynomial = new Polynomial();
        String regex = "([-+]?[0-9]*)(?:\\*)?(x(?:\\^[0-9]+)?)?";
        Pattern termPattern = Pattern.compile(regex);
        Matcher matcher = termPattern.matcher(polynomialInput);
       /* if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid polynomial.");
            return null;
        }  */
        while (matcher.find()) {
            Double coefficient;
            if (matcher.start() == 0 && matcher.group(1).isEmpty()) {
                if (matcher.group(2) != null) {
                    coefficient = 1.0;
                }
                else {
                    coefficient=0.0;
                }
            } else if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
                if (matcher.group(1).equals("+")) {
                    coefficient = 1.0;
                } else if (matcher.group(1).equals("-")) {
                    coefficient = -1.0;
                } else {
                    coefficient = Double.parseDouble(matcher.group(1));
                }
            } else {
                coefficient = 0.0;
            }
            Integer exponent;
            if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                if (matcher.group(2).length() >= 2) {
                    exponent = Integer.parseInt(matcher.group(2).substring(2));
                } else {
                    exponent = 1;
                }
            } else {
                exponent = 0;
            }
            polynomial.addMonomial(new Monomial(exponent, coefficient));
        }
        return polynomial;
    }

    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
        Integer exponent;
        Double coefficient;
        for (Map.Entry<Integer, Double> i : p1.getPolynomial().entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            p3.getPolynomial().put(exponent, coefficient);
        }
        for (Map.Entry<Integer, Double> i : p2.getPolynomial().entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            if (p3.getPolynomial().containsKey(exponent)) {
                coefficient += p3.getPolynomial().get(exponent);
            }
            p3.getPolynomial().put(exponent, coefficient);
            if (coefficient == 0) {
                p3.getPolynomial().remove(exponent);
            }
        }
        return p3;
    }

    public static Polynomial subtractPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
        Integer exponent;
        Double coefficient;
        for (Map.Entry<Integer, Double> i : p1.getPolynomial().entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            p3.getPolynomial().put(exponent, coefficient);
        }
        for (Map.Entry<Integer, Double> i : p2.getPolynomial().entrySet()) {
            exponent = i.getKey();
            coefficient = -i.getValue();
            if (p3.getPolynomial().containsKey(exponent)) {
                coefficient += p3.getPolynomial().get(exponent);
            }
            p3.getPolynomial().put(exponent, coefficient);
        }
        return p3;
    }

    public static Polynomial multiplyPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
        Integer exponent;
        Double coefficient;
        for (Map.Entry<Integer, Double> i : p1.getPolynomial().entrySet()) {
            for (Map.Entry<Integer, Double> j : p2.getPolynomial().entrySet()) {
                exponent = i.getKey() + j.getKey();
                coefficient = i.getValue() * j.getValue();
                if (p3.getPolynomial().containsKey(exponent)) {
                    coefficient += p3.getPolynomial().get(exponent);
                }
                p3.getPolynomial().put(exponent, coefficient);
            }
        }
        return p3;
    }

    public static Polynomial[] dividePolynomials(Polynomial p1, Polynomial p2) {
        if (p2.getPolynomial().isEmpty() || p2.getPolynomial().firstEntry().getValue() == 0) {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (p1.getDegree() < p2.getDegree()) {
            return new Polynomial[]{new Polynomial(), p1};
        }
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(p1.getPolynomial());
        while (remainder.getDegree() >= p2.getDegree()) {
            Integer p1Exponent = remainder.getDegree();
            Integer p2Exponent = p2.getDegree();
            Integer quotientExponent = p1Exponent - p2Exponent;
            Double quotientCoefficient = remainder.getCoefficient(p1Exponent) / p2.getCoefficient(p2Exponent);
            Polynomial poly = new Polynomial();
            poly.addMonomial(new Monomial(quotientExponent, quotientCoefficient));
            quotient = addPolynomials(quotient, poly);
            Polynomial temp = multiplyPolynomials(p2, poly);
            remainder = subtractPolynomials(remainder, temp);
            // removing the term if its coefficient is zero
            Set<Integer> exponents = new HashSet<>(remainder.getPolynomial().keySet());
            for (Integer exponent : exponents) {
                if (remainder.getPolynomial().get(exponent) == 0) {
                    remainder.getPolynomial().remove(exponent);
                }
            }
        }
        return new Polynomial[]{quotient, remainder};
    }

    public static Polynomial derivePolynomial(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> i : polynomial.getPolynomial().entrySet()) {
            Integer exponent = i.getKey();
            Double coefficient = i.getValue();
            if (exponent == 0) {
                result.addMonomial(new Monomial(0, 0.0));
            } else {
                result.addMonomial(new Monomial(exponent - 1, coefficient * exponent));
            }
        }
        return result;
    }

    public static Polynomial integratePolynomial(Polynomial p1) {
        Polynomial result = new Polynomial();
        Integer exponent;
        Double coefficient;
        for (Map.Entry<Integer, Double> i : p1.getPolynomial().entrySet()) {
            exponent = i.getKey();
            coefficient = i.getValue();
            if (exponent == 0) {
                result.addMonomial(new Monomial(1, coefficient));
            } else {
                result.addMonomial(new Monomial(exponent + 1, coefficient / (exponent + 1)));
            }
        }
        return result;
    }
}