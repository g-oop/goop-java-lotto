package calculator.calculator;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("도메인 - MathIngredient 테스트")
class MathIngredientTest {

    static Stream<Arguments> invalidMathIngredients() {
        return Stream.of(
            Arguments.of(List.of("2", " ", "4"), "blank")
        );
    }

    @DisplayName("생성자 유효성 검사 테스트")
    @ParameterizedTest
    @MethodSource("invalidMathIngredients")
    void initMathIngredient_무효값_예외처리(List<String> mathIngredients, String expected) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> mathIngredients.stream().map(MathIngredient::new).toList()
        ).withMessage("유효하지 않은 인자 : " + expected);
    }
}
