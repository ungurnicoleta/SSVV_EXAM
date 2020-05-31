package FractionMV;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fraction {
    private int numerator, denominator;

    public void Simplify() {
        long gcd = GCD(denominator, numerator);
        denominator /= gcd;
        numerator /= gcd;

        if(denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }
    private static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
