package calculator.data.type;

import calculator.view.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperationTest {

    @Test
    @DisplayName("덧셈 테스트")
    public void addTest(){
        Operation addition = Operation.ADDITION;
        int result = addition.apply(3, 5);
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtractTest(){
        Operation subtraction  = Operation.SUBTRACTION;
        int result = subtraction.apply(8, 5);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱하기 테스트")
    public void multiplyTest(){

        Operation multiplication  = Operation.MULTIPLICATION;
        int result = multiplication.apply(2, 5);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void divideTest(){
        Operation division  = Operation.DIVISION;
        int result = division.apply(10,5);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("0이거나 정수로 떨어지지않을때 예외를 던진다.")
    public void divideByZeroHandler(){
        Operation division  = Operation.DIVISION;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->division.apply(5,0)).withMessageMatching("0으로 나눌 수 없습니다.");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->division.apply(5,7)).withMessageMatching("나눗셈 결과가 정수로 떨어지지 않습니다.");
    }


}
