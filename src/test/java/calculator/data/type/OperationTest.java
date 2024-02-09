package calculator.data.type;

import calculator.view.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperationTest {

    @Test
    @DisplayName("덧셈 테스트")
    public void addTest(){
        int num1 = 3;
        int num2 = 5;
        int expectedValue = 8;
        Operation addition = Operation.ADDITION;
        int result = addition.apply(num1, num2);
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtractTest(){
        int num1 = 8;
        int num2 = 5;
        int expectedValue = 3;
        Operation subtraction  = Operation.SUBTRACTION;
        int result = subtraction.apply(num1, num2);
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("곱하기 테스트")
    public void multiplyTest(){
        int num1 = 2;
        int num2 = 5;
        int expectedValue = 10;
        Operation multiplication  = Operation.MULTIPLICATION;
        int result = multiplication.apply(num1, num2);
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void divideTest(){
        int num1 = 10;
        int num2 = 5;
        int expectedValue = 2;
        Operation division  = Operation.DIVISION;
        int result = division.apply(num1, num2);
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    public void InputValidationForNullAndEmptyValues(){
        var blankString = "";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Input.getInput(null)).withMessageMatching("입력 값이 Null이거나 빈 공백 문자입니다.");

        // 빈 문자열 입력 값에 대한 테스트
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Input.getInput(blankString)).withMessageMatching("입력 값이 Null이거나 빈 공백 문자입니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    public void isNotArithmeticOperator(){
        String operation = "!";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Operation.identifyOperations(operation)).withMessageMatching("사칙연산 기호가 아닙니다.!");

    }
}
