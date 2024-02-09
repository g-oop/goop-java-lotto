package calculator.calculator;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("도메인 - Calculator 테스트")
class CalculatorTest {

    static Stream<Arguments> mathIngredients() {
        return Stream.of(
            Arguments.of(List.of("1", "+", "2").stream().map(MathIngredient::new).toList(), 3),
            Arguments.of(List.of("2", "-", "1").stream().map(MathIngredient::new).toList(), 1),
            Arguments.of(List.of("2", "*", "2").stream().map(MathIngredient::new).toList(), 4),
            Arguments.of(List.of("4", "/", "2").stream().map(MathIngredient::new).toList(), 2),
            Arguments.of(List.of("4", "+", "2", "-", "2", "*", "2", "/", "2").stream().map(MathIngredient::new).toList(), 4)
        );
    }

    static Stream<Arguments> invalidMathIngredients() {
        return Stream.of(
            Arguments.of(List.of("1", "+", "*").stream().map(MathIngredient::new).toList(), "*")
        );
    }

    @DisplayName("계산 결과 테스트")
    @ParameterizedTest
    @MethodSource("mathIngredients")
    void calculate(List<MathIngredient> mathIngredients, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(mathIngredients);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("무효값 계산 예외 테스트")
    @ParameterizedTest
    @MethodSource("invalidMathIngredients")
    void calculate_유효하지_않은_수식_예외처리(List<MathIngredient> mathIngredients, String expected) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(
            () -> calculator.calculate(mathIngredients)
        ).withMessage("유효하지 않은 인자 : " + expected);
    }
}
