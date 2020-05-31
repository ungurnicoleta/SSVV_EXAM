package FractionMV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUpFraction() {
        this.fraction = new Fraction(12, 13);
    }

    @Test
    void getNumerator() {
        assertEquals(this.fraction.getNumerator(), 12);
    }

    @Test
    void getDenominator() {
        assertEquals(this.fraction.getDenominator(), 13);
    }

    @Test
    void setNumerator() {
        this.fraction.setNumerator(11);
        assertEquals(this.fraction.getNumerator(), 11);
    }

    @Test
    void setDenominator() {
        this.fraction.setNumerator(15);
        assertEquals(this.fraction.getNumerator(), 15);
    }

    @ParameterizedTest
    @MethodSource("simplifyFractionsProvider")
    public void testSimplify(Fraction first, Fraction second) {
        first.Simplify();
        assertEquals(first.getNumerator(), second.getNumerator());
        assertEquals(first.getDenominator(), second.getDenominator());
    }

    static Stream<Arguments> simplifyFractionsProvider() {
        return Stream.of(
                Arguments.of(new Fraction(12, 30), new Fraction(2, 5)),
                Arguments.of(new Fraction(-25, 7), new Fraction(-25, 7))
        );
    }
}
