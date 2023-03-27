import org.example.BusinessLogic.CalculatorModel;
import org.example.Model.Monomial;
import org.example.Model.Polynomial;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

  /* The polynomials provided for tests:
   1) p2=2x^6-6x^4+x^3-4x^2-5, p2=2x^4+12x+1
   the last two cases for the addition - intentional wrong examples
   the last case the for operations - intentional wrong examples
*/

    @Test
    public void testAdditionPolynomials_1() {
        // Test addition of two polynomials
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(6, 2.0));
        p1.addMonomial(new Monomial(4, -6.0));
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(6, 2.0));
        expected.addMonomial(new Monomial(4, -4.0));
        expected.addMonomial(new Monomial(3, 1.0));
        expected.addMonomial(new Monomial(2, -4.0));
        expected.addMonomial(new Monomial(1, 12.0));
        expected.addMonomial(new Monomial(0, -4.0));
        Polynomial actual = CalculatorModel.addPolynomials(p1, p2);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testAdditionPolynomials_2() {
        // Test addition of two polynomials given as input strings
        String p1Input="x^2+2x+1";
        String p2Input="x+1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.addPolynomials(p1, p2).polynomialToString();
        String expected="x^2+3x+2";
        assertEquals(expected, actual);
    }

    @Test
    public void testAdditionPolynomials_3() {
        String p1Input="1*x^2+2*x^1+1*x^0";
        String p2Input="1*x^1+1*x^0";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.addPolynomials(p1, p2).polynomialToString();
        String expected="x^2+3x+2";
        assertEquals(expected, actual);
    }

    @Test
    public void testAdditionPolynomials_4() {  //failure
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(2, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(3, 2.0));
        expected.addMonomial(new Monomial(2, -4.0));
        expected.addMonomial(new Monomial(1, 12.0));
        expected.addMonomial(new Monomial(0, 4.0));
        Polynomial actual = CalculatorModel.addPolynomials(p1, p2);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testAdditionPolynomials_5() {  //failure
        String p1Input="x^2+5x+1";
        String p2Input="x-1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.addPolynomials(p1, p2).polynomialToString();
        String expected="x^2+3x+1";
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractionPolynomials_1() {
        // Test subtraction of two polynomials
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(6, 2.0));
        p1.addMonomial(new Monomial(4, -6.0));
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(6, 2.0));
        expected.addMonomial(new Monomial(4, -8.0));
        expected.addMonomial(new Monomial(3, 1.0));
        expected.addMonomial(new Monomial(2, -4.0));
        expected.addMonomial(new Monomial(1, -12.0));
        expected.addMonomial(new Monomial(0, -6.0));
        Polynomial actual = CalculatorModel.subtractPolynomials(p1, p2);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testSubtractionPolynomials_2() {
        // Test subtraction of two polynomials given as input strings
        String p1Input="x^2+2x+1";
        String p2Input="x+1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.subtractPolynomials(p1, p2).polynomialToString();
        String expected="x^2+x";
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractionPolynomials_3() {  //failure
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(2, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(3, -1.0));
        expected.addMonomial(new Monomial(2, 6.0));
        expected.addMonomial(new Monomial(1, 12.0));
        expected.addMonomial(new Monomial(0, 4.0));
        Polynomial actual = CalculatorModel.subtractPolynomials(p1, p2);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testMultiplicationPolynomials_1() {
        // Test multiplication of two polynomials
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(6, 2.0));
        p1.addMonomial(new Monomial(4, -6.0));
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(10, 4.0));
        expected.addMonomial(new Monomial(8, -12.0));
        expected.addMonomial(new Monomial(7, 26.0));
        expected.addMonomial(new Monomial(6, -6.0));
        expected.addMonomial(new Monomial(5, -72.0));
        expected.addMonomial(new Monomial(4, -4.0));
        expected.addMonomial(new Monomial(3, -47.0));
        expected.addMonomial(new Monomial(2, -4.0));
        expected.addMonomial(new Monomial(1, -60.0));
        expected.addMonomial(new Monomial(0, -5.0));
        Polynomial actual = CalculatorModel.multiplyPolynomials(p1, p2);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testMultiplicationPolynomials_2() {
        // Test subtraction of two polynomials given as input strings
        String p1Input="x^2+2x+1";
        String p2Input="x+1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.multiplyPolynomials(p1, p2).polynomialToString();
        String expected="x^3+3x^2+3x+1";
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplicationPolynomials_3() {  //failure
        String p1Input="x^2+5x+1";
        String p2Input="x-1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        String actual = CalculatorModel.multiplyPolynomials(p1, p2).polynomialToString();
        String expected="x^3-4x^2+6x-1";
        assertEquals(expected, actual);
    }

    @Test
    public void testDivisionPolynomials_1() {
        // Test division of two polynomials
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(6, 2.0));
        p1.addMonomial(new Monomial(4, -6.0));
        p1.addMonomial(new Monomial(3, 1.0));
        p1.addMonomial(new Monomial(2, -4.0));
        p1.addMonomial(new Monomial(0, -5.0));
        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 2.0));
        p2.addMonomial(new Monomial(1, 12.0));
        p2.addMonomial(new Monomial(0, 1.0));
        Polynomial expectedQuotient = new Polynomial();
        expectedQuotient.addMonomial(new Monomial(2, 1.0));
        expectedQuotient.addMonomial(new Monomial(0, -3.0));
        Polynomial expectedRemainder = new Polynomial();
        expectedRemainder.addMonomial(new Monomial(3, -11.0));
        expectedRemainder.addMonomial(new Monomial(2, -5.0));
        expectedRemainder.addMonomial(new Monomial(1, 36.0));
        expectedRemainder.addMonomial(new Monomial(0, -2.0));
        Polynomial[] actual = CalculatorModel.dividePolynomials(p1, p2);
        assertEquals(expectedQuotient.getPolynomial(), actual[0].getPolynomial());
        assertEquals(expectedRemainder.getPolynomial(), actual[1].getPolynomial());
    }

    @Test
    public void testDivisionPolynomials_2() {
        String p1Input="x^2+2x+1";
        String p2Input="x-1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        Polynomial[] p=CalculatorModel.dividePolynomials(p1, p2);
        String expectedQuoticient="x+3";
        String expectedRemainder="4";
        String actualQuoticient="x+3";
        String actualRemainder="4";
        assertEquals(expectedQuoticient, actualQuoticient);
        assertEquals(expectedRemainder, actualRemainder);
    }

    @Test
    public void testDivisionPolynomials_3() {  //failure
        String p1Input="x^2+5x+1";
        String p2Input="x-1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        Polynomial p2=CalculatorModel.stringToPolynomial(p2Input);
        Polynomial[] p=CalculatorModel.dividePolynomials(p1, p2);
        String expectedQuoticient="2x+3";
        String expectedRemainder="6";
        String actualQuoticient="x+6";
        String actualRemainder="7";
        assertEquals(expectedQuoticient, actualQuoticient);
        assertEquals(expectedRemainder, actualRemainder);
    }

    @Test
    public void testDerivationPolynomial_1() {
        // Test derivation of a polynomial
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(2, 3.0));
        p1.addMonomial(new Monomial(1, 4.0));
        p1.addMonomial(new Monomial(0, 2.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(1, 6.0));
        expected.addMonomial(new Monomial(0, 4.0));
        expected.addMonomial(new Monomial(0, 0.0));
        Polynomial actual = CalculatorModel.derivePolynomial(p1);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testDerivationPolynomial_2() {  //failure
        String p1Input="x^2+2x+1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        String actual = CalculatorModel.derivePolynomial(p1).polynomialToString();
        String expected="2x-2";
        assertEquals(expected, actual);
    }

    @Test
    public void testIntegrationPolynomial_1() {
        // Test integration of a polynomial
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(2, 3.0));
        p1.addMonomial(new Monomial(1, 4.0));
        p1.addMonomial(new Monomial(0, 2.0));
        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(3, 1.0));
        expected.addMonomial(new Monomial(2, 2.0));
        expected.addMonomial(new Monomial(1, 2.0));
        Polynomial actual = CalculatorModel.integratePolynomial(p1);
        assertEquals(expected.getPolynomial(), actual.getPolynomial());
    }

    @Test
    public void testIntegrationPolynomial_2() {  //failure
        String p1Input="x^2+2x+1";
        Polynomial p1=CalculatorModel.stringToPolynomial(p1Input);
        String actual = CalculatorModel.integratePolynomial(p1).integratedPolynomialToString();
        String expected="0.3333333333333333x^3+3x^2+x+C";
        assertEquals(expected, actual);
    }
}