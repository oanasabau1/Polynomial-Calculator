package org.example.Model;

public class Monomial {
    private Integer exponent;
    private Double coefficient;

    public Monomial(Integer exponent, Double coefficient) {
        this.exponent=exponent;
        this.coefficient=coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
    public Double getCoefficient() {
        return coefficient;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    public Integer getExponent() {
        return exponent;
    }
}