package calculator.alu;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("도메인 - Calculator 테스트")
class CalculatorTest {

    static Stream<Arguments> methIngredients() {
        return Stream.of(
            Arguments.of(List.of("1", "+", "2").stream().map(MethIngredient::new).toList(), 3),
            Arguments.of(List.of("2", "-", "1").stream().map(MethIngredient::new).toList(), 1),
            Arguments.of(List.of("2", "*", "2").stream().map(MethIngredient::new).toList(), 4),
            Arguments.of(List.of("4", "/", "2").stream().map(MethIngredient::new).toList(), 2),
            Arguments.of(List.of("4", "+", "2", "-", "2", "*", "2", "/", "2").stream().map(MethIngredient::new).toList(), 4)
        );
    }

    static Stream<Arguments> invalidMethIngredients() {
        return Stream.of(
            Arguments.of(List.of("1", "+", "*").stream().map(MethIngredient::new).toList(), "*"),
            Arguments.of(List.of("2", "+", "1", "3").stream().map(MethIngredient::new).toList(), "3")
        );
    }

    @DisplayName("계산 결과 테스트")
    @ParameterizedTest
    @MethodSource("methIngredients")
    void calculate(List<MethIngredient> methIngredients, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(methIngredients);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("무효값 계산 예외 테스트")
    @ParameterizedTest
    @MethodSource("invalidMethIngredients")
    void calculate_유효하지_않은_수식_예외처리(List<MethIngredient> methIngredients, String expected) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(
            () -> calculator.calculate(methIngredients)
        ).withMessage("유효하지 않은 인자 : " + expected);
    }
}
