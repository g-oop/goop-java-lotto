package calculator.data.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ArithmeticOperatorTest {

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외를 던진다.")
    public void isNotArithmeticOperator(){
        String operation = "!";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Operation.identifyOperations(operation)).withMessageMatching("사칙연산 기호가 아닙니다.!");
    }
}
