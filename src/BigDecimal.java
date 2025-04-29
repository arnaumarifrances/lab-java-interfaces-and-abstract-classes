/* Using the BigDecimal documentation, create a method that accepts a BigDecimal and returns a double of the BigDecimal
number rounded to the nearest hundredth. For example, 4.2545 should return 4.25.
Using the BigDecimal documentation, create a method that accepts a BigDecimal, reverses the sign (if the parameter is
positive, the result should be negative and vice versa), rounds the number to the nearest tenth and returns the result.
For example, 1.2345 should return -1.2 and -45.67 should return 45.7 */

import java.math.RoundingMode;

public class BigDecimal {

    // Redondea con 2 decimales (setScale(2, RoundingMode.HALF_UP)) y devuelve como double
    public static double redondearACentesima(java.math.BigDecimal num) {
        return num.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Invierte el signo (negate()), redondea 1 decimal y devuelve como BigDecimal
    public static java.math.BigDecimal invertirYRedondearADecima(java.math.BigDecimal num) {
        return num.negate().setScale(1, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        // Pruebas
        System.out.println(redondearACentesima(new java.math.BigDecimal("4.2545")));  // 4.25
        System.out.println(invertirYRedondearADecima(new java.math.BigDecimal("1.2345")));  // -1.2
        System.out.println(invertirYRedondearADecima(new java.math.BigDecimal("-45.67")));  // 45.7
    }
}

